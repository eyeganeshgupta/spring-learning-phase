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
import java.util.Date;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private static final long JWT_EXPIRATION_MS = 1000 * 60 * 60;
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
        logger.info("JWT Utility initialized successfully");
    }

    public String generateToken(String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(signingKey)
                .compact();

        logger.debug("Generated JWT token for email='{}', expiresAt={}", email, expiryDate);
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
            logger.warn("JWT token expired at {}", ex.getClaims().getExpiration());
            throw ex;
        } catch (JwtException ex) {
            logger.error("Invalid JWT token: {}", ex.getMessage());
            throw ex;
        }
    }

    public String extractEmail(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject();
    }

}
