package io.spring.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${jwt.expiration-ms:3600000}")
    private long jwtExpirationMs;

    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey signingKey;

    @PostConstruct
    private void init() {
        if (secretKey == null || secretKey.trim().isEmpty()) {
            logger.error("JWT secret key is not configured");
            throw new IllegalStateException("JWT secret key must not be null or empty");
        }
        this.signingKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        logger.info("JWT utility initialized (token TTL = {} ms)", jwtExpirationMs);
    }

    public String generateToken(String email, List<String> roles) {
        Objects.requireNonNull(email, "email must not be null");
        Date now = new Date();
        Date expiry = new Date(now.getTime() + jwtExpirationMs);

        String token = Jwts.builder()
                .setSubject(email)
                .claim("roles", roles == null ? Collections.emptyList() : roles)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(signingKey)
                .compact();

        logger.debug("Generated JWT for email='{}' with expiration={}", email, expiry);
        return token;
    }

    public Claims extractClaims(String token) {
        try {
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build();

            Jws<Claims> claimsJws = parser.parseClaimsJws(token);

            return claimsJws.getBody();
        } catch (ExpiredJwtException ex) {
            logger.debug("Attempt to parse expired JWT (expiredAt={})", ex.getClaims() != null ? ex.getClaims().getExpiration() : "unknown");
            throw ex;
        } catch (JwtException ex) {
            logger.warn("Failed to parse JWT: {}", ex.getMessage());
            throw ex;
        }
    }

    public String extractEmail(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject();
    }

    public boolean isTokenExpired(String token) {
        try {
            Date expiration = extractClaims(token).getExpiration();
            boolean expired = expiration == null || expiration.before(new Date());
            if (expired) {
                logger.debug("JWT is expired (expiration={})", expiration);
            }
            return expired;
        } catch (ExpiredJwtException ex) {
            return true;
        } catch (JwtException ex) {
            logger.debug("isTokenExpired check failed parsing token: {}", ex.getMessage());
            return true;
        }
    }

}
