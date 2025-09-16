package io.spring.service;

import io.spring.model.Customer;
import io.spring.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private static final String DEFAULT_ROLE = "ROLE_USER";

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = Objects.requireNonNull(customerRepository, "customerRepository must not be null");
        this.passwordEncoder = Objects.requireNonNull(passwordEncoder, "passwordEncoder must not be null");
    }

    public Customer register(String email, String rawPassword, Double initialBalance) {
        if (email == null || email.trim().isEmpty()) {
            logger.warn("Attempt to register with empty or null email");
            throw new IllegalArgumentException("Email must not be empty");
        }
        if (rawPassword == null || rawPassword.isEmpty()) {
            logger.warn("Attempt to register user '{}' with empty password", email);
            throw new IllegalArgumentException("Password must not be empty");
        }

        final String normalizedEmail = email.trim().toLowerCase();
        final double balance = initialBalance == null ? 0.0 : initialBalance;

        logger.info("Registration requested for email='{}'", normalizedEmail);

        Optional<Customer> existing = customerRepository.findByEmail(normalizedEmail);
        if (existing.isPresent()) {
            logger.debug("Registration failed: email '{}' already in use", normalizedEmail);
            throw new IllegalArgumentException("An account with the provided email already exists");
        }

        String encodedPassword = passwordEncoder.encode(rawPassword);

        Customer customer = new Customer();
        customer.setEmail(normalizedEmail);
        customer.setPassword(encodedPassword);
        customer.setRole(DEFAULT_ROLE);
        customer.setBalance(balance);

        Customer saved;
        try {
            saved = customerRepository.save(customer);
            logger.info("Successfully registered new customer with email='{}', id={}", normalizedEmail, saved.getId());
        } catch (Exception ex) {
            logger.error("Failed to persist customer with email='{}'. Reason: {}", normalizedEmail, ex.getMessage(), ex);
            throw new IllegalStateException("Unable to complete registration at this time", ex);
        }

        return saved;
    }
}
