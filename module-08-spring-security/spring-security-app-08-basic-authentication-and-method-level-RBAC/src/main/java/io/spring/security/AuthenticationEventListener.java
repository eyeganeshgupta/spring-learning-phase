package io.spring.security;

import io.spring.model.User;
import io.spring.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthenticationEventListener implements
        ApplicationListener<org.springframework.context.ApplicationEvent> {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationEventListener.class);
    private static final int MAX_FAILED_ATTEMPTS = 3;

    public AuthenticationEventListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(org.springframework.context.ApplicationEvent event) {
        if (event instanceof AuthenticationFailureBadCredentialsEvent failureEvent) {
            String username = (String) failureEvent.getAuthentication().getPrincipal();
            logger.info("Authentication failed for user: {}", username);

            User user = userRepository.findByUsername(username);
            if (user != null) {
                int newFailAttempts = user.getFailedAttempts() + 1;
                user.setFailedAttempts(newFailAttempts);
                if (newFailAttempts >= MAX_FAILED_ATTEMPTS) {
                    user.setAccountNonLocked(false);
                    logger.info("User account locked due to too many failed attempts: {}", username);
                }
                userRepository.save(user);
            }
        } else if (event instanceof AuthenticationSuccessEvent successEvent) {
            String username = successEvent.getAuthentication().getName();
            logger.info("Authentication successful for user: {}", username);

            User user = userRepository.findByUsername(username);
            if (user != null && user.getFailedAttempts() > 0) {
                user.setFailedAttempts(0);
                user.setAccountNonLocked(true);
                userRepository.save(user);
                logger.info("Failed login attempts reset and account unlocked for user: {}", username);
            }
        }
    }
}
