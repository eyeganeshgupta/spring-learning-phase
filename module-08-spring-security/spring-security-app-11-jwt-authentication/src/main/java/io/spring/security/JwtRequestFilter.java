package io.spring.security;

import io.spring.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    private final JwtUtil jwtUtil;

    public JwtRequestFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        final String requestUri = request.getRequestURI();

        logger.info("Starting JWT authentication filter for URI: {}", requestUri);

        String jwtToken = null;
        String userEmail = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            logger.debug("Authorization header found and token extracted");

            try {
                userEmail = jwtUtil.extractEmail(jwtToken);
                logger.debug("Email extracted from JWT: {}", userEmail);
            } catch (Exception e) {
                logger.error("Failed to extract email from JWT: {}", e.getMessage());
            }

        } else {
            logger.info("No Bearer token found in Authorization header");
        }

        // Proceeding only if userEmail is extracted and no authentication is already present
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                boolean isTokenValid = jwtUtil.validateToken(jwtToken, userEmail);
                logger.debug("Token validation result for {}: {}", userEmail, isTokenValid);

                if (isTokenValid) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userEmail, null, Collections.emptyList());

                    authenticationToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    logger.info("Security context set for authenticated user: {}", userEmail);
                } else {
                    logger.warn("JWT token is invalid for user: {}", userEmail);
                }
            } catch (Exception e) {
                logger.error("Error during JWT validation for user {}: {}", userEmail, e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}
