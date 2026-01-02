package io.spring.service;

import io.spring.model.Customer;
import io.spring.repository.CustomerRepository;
import io.spring.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Service responsible for registration, customer lookup and token generation.
 */
@Service
@Transactional
public final class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private static final Set<String> ALLOWED_ROLES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("ROLE_USER", "ROLE_ADMIN")));

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(CustomerRepository customerRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.customerRepository = Objects.requireNonNull(customerRepository, "customerRepository must not be null");
        this.passwordEncoder = Objects.requireNonNull(passwordEncoder, "passwordEncoder must not be null");
        this.jwtUtil = Objects.requireNonNull(jwtUtil, "jwtUtil must not be null");
    }

    public Customer register(String email, String rawPassword, Double initialBalance, String role) {
        if (email == null || email.trim().isEmpty()) {
            logger.warn("Attempt to register with empty or null email");
            throw new IllegalArgumentException("Email must not be empty");
        }
        if (rawPassword == null || rawPassword.isEmpty()) {
            logger.warn("Attempt to register user '{}' with empty password", email);
            throw new IllegalArgumentException("Password must not be empty");
        }

        final String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);
        final double balance = initialBalance == null ? 0.0 : initialBalance;
        final String resolvedRole = resolveRole(role);

        logger.info("Registration requested for email='{}' with role='{}'", normalizedEmail, resolvedRole);

        if (customerRepository.findByEmail(normalizedEmail).isPresent()) {
            logger.debug("Registration failed: email '{}' already in use", normalizedEmail);
            throw new IllegalArgumentException("An account with the provided email already exists");
        }

        String encodedPassword = passwordEncoder.encode(rawPassword);

        Customer customer = new Customer();
        customer.setEmail(normalizedEmail);
        customer.setPassword(encodedPassword);
        customer.setRole(resolvedRole);
        customer.setBalance(balance);

        try {
            Customer saved = customerRepository.save(customer);
            logger.info("Successfully registered new customer email='{}', id={}", normalizedEmail, saved.getId());
            return saved;
        } catch (Exception ex) {
            logger.error("Failed to persist customer with email='{}'. Reason: {}", normalizedEmail, ex.getMessage(), ex);
            throw new IllegalStateException("Unable to complete registration at this time", ex);
        }
    }

    public Customer getCustomerDetails(String email) {
        if (email == null || email.trim().isEmpty()) {
            logger.warn("Attempt to fetch customer details with empty or null email");
            throw new IllegalArgumentException("Email must not be empty");
        }

        final String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);
        logger.debug("Fetching customer details for email='{}'", normalizedEmail);

        try {
            return customerRepository.findByEmail(normalizedEmail)
                    .map(customer -> {
                        logger.info("Successfully retrieved details for customer email='{}', id={}", normalizedEmail, customer.getId());
                        return customer;
                    })
                    .orElseThrow(() -> {
                        logger.info("No customer found with email='{}'", normalizedEmail);
                        return new IllegalArgumentException("Customer with the provided email does not exist");
                    });
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            logger.error("Error while retrieving customer details for email='{}'. Reason: {}", normalizedEmail, ex.getMessage(), ex);
            throw new IllegalStateException("Unable to retrieve customer details at this time", ex);
        }
    }

    public String generateToken(String email) {
        if (email == null || email.trim().isEmpty()) {
            logger.warn("Attempt to generate token with empty or null email");
            throw new IllegalArgumentException("Email must not be empty");
        }

        final String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);
        logger.debug("Generating token for email='{}'", normalizedEmail);

        Customer customer = customerRepository.findByEmail(normalizedEmail)
                .orElseThrow(() -> {
                    logger.info("Cannot generate token: no customer found for email='{}'", normalizedEmail);
                    return new IllegalArgumentException("Customer with the provided email does not exist");
                });

        List<String> roles = extractRolesFromCustomer(customer);
        try {
            String token = jwtUtil.generateToken(normalizedEmail, roles);
            logger.info("Token generated for email='{}' (roles={})", normalizedEmail, roles);
            return token;
        } catch (Exception ex) {
            logger.error("Failed to generate JWT for email='{}'. Reason: {}", normalizedEmail, ex.getMessage(), ex);
            throw new IllegalStateException("Failed to generate authentication token", ex);
        }
    }

    private static String resolveRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            return DEFAULT_ROLE;
        }
        String normalized = role.trim().toUpperCase(Locale.ROOT);
        if (!ALLOWED_ROLES.contains(normalized)) {
            throw new IllegalArgumentException("Role must be one of " + ALLOWED_ROLES);
        }
        return normalized;
    }

    private static List<String> extractRolesFromCustomer(Customer customer) {
        if (customer == null || customer.getRole() == null || customer.getRole().trim().isEmpty()) {
            return Collections.singletonList(DEFAULT_ROLE);
        }
        String raw = customer.getRole().trim();

        String[] parts = raw.split("\\s*,\\s*");
        List<String> roles = new ArrayList<>();
        for (String p : parts) {
            if (!p.isEmpty()) {
                roles.add(p.toUpperCase(Locale.ROOT));
            }
        }
        return roles.isEmpty() ? Collections.singletonList(DEFAULT_ROLE) : roles;
    }

}
