package io.spring.service;

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

}
