package io.spring.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);
    private final ObjectMapper objectMapper;

    public CustomAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /*
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        String errorMessage = "Invalid username or password";

        if (authException instanceof LockedException) {
            errorMessage = "Your account has been locked due to too many failed login attempts. Please contact support or try again later.";
        }

        logger.info("Unauthorized access attempt to URI: {}", request.getRequestURI());
        logger.info("AuthenticationException message: {}", errorMessage);

        ApiResponse<Object> errorResponse = ApiResponse.builder()
                .success(false)
                .message(errorMessage)
                .data(errorMessage)
                .build();

        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
     */

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        String errorMessage = "Invalid username or password";

        Throwable cause = authException;
        while (cause != null) {
            if (cause instanceof LockedException) {
                errorMessage = "Your account has been locked due to too many failed login attempts. Please contact support or try again later.";
                break;
            }
            cause = cause.getCause();
        }

        logger.info("Unauthorized access attempt to URI: {}", request.getRequestURI());
        logger.info("AuthenticationException message: {}", errorMessage);

        ApiResponse<Object> errorResponse = ApiResponse.builder()
                .success(false)
                .message(errorMessage)
                .data(errorMessage)
                .build();

        response.reset();

        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
