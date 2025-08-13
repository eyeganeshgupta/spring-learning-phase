package io.spring.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomBasicAuthenticationFilter extends BasicAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomBasicAuthenticationFilter.class);
    private final AuthenticationFailureHandler failureHandler;

    public CustomBasicAuthenticationFilter(AuthenticationManager authenticationManager,
                                           AuthenticationFailureHandler failureHandler) {
        super(authenticationManager);
        this.failureHandler = failureHandler;
    }

    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request,
                                                HttpServletResponse response,
                                                AuthenticationException failed) {
        logger.info("Unsuccessful authentication attempt.");
        try {
            failureHandler.onAuthenticationFailure(request, response, failed);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
