package io.spring.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    private static final ConcurrentHashMap<String, UserRateLimit> rateLimits = new ConcurrentHashMap<>();
    private static final long TIME_WINDOW = TimeUnit.MINUTES.toMillis(1);
    private static final int MAX_REQUESTS = 5;

    public static boolean isRateLimited(String username) {
        UserRateLimit rateLimit = rateLimits.getOrDefault(username, new UserRateLimit());
        long currentTime = System.currentTimeMillis();

        if (currentTime - rateLimit.lastRequestTime > TIME_WINDOW) {
            rateLimit.requestCount = 0;
        }

        if (rateLimit.requestCount >= MAX_REQUESTS) {
            return true;
        }

        rateLimit.requestCount++;
        rateLimit.lastRequestTime = currentTime;
        rateLimits.put(username, rateLimit);

        return false;
    }

    private static class UserRateLimit {
        long lastRequestTime;
        int requestCount;
    }
}
