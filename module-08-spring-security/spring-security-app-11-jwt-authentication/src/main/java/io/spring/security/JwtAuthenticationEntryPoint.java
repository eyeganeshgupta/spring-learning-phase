package io.spring.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    private static final String DEFAULT_ERROR_MESSAGE = "Authentication required: invalid or missing token";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ISO_INSTANT;

    private static String escapeJson(String input) {
        if (input == null) return "";
        return input
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        Objects.requireNonNull(response, "HttpServletResponse must not be null");

        String requestPath = request == null ? "unknown" : request.getRequestURI();
        String reason = authException == null ? "unspecified authentication failure" : authException.getMessage();
        logger.warn("Unauthorized request to '{}': {}", requestPath, reason);

        if (authException != null && logger.isDebugEnabled()) {
            logger.debug("AuthenticationException details:", authException);
        }

        String timestamp = TIMESTAMP_FORMATTER.format(Instant.now());
        int status = HttpServletResponse.SC_UNAUTHORIZED;
        String error = "Unauthorized";

        String jsonPayload = String.format(
                "{\"timestamp\":\"%s\",\"status\":%d,\"error\":\"%s\",\"message\":\"%s\",\"path\":\"%s\"}",
                timestamp, status, escapeJson(error), escapeJson(DEFAULT_ERROR_MESSAGE), escapeJson(requestPath)
        );

        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(status);

        PrintWriter out = response.getWriter();
        out.write(jsonPayload);
        out.flush();
    }
}
