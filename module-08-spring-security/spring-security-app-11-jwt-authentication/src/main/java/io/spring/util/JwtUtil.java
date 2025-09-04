package io.spring.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    public JwtUtil() {
        System.out.println("secretKey: " + secretKey);
    }

    private SecretKey getSigningKey() {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        return key;
    }

}
