package io.spring.controller;

import io.spring.dto.ApiResponse;
import io.spring.dto.RegisterRequest;
import io.spring.model.Customer;
import io.spring.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/auth", produces = "application/json")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = Objects.requireNonNull(authService, "authService must not be null");
        this.authenticationManager = Objects.requireNonNull(authenticationManager, "authenticationManager must not be null");
    }

    @PostMapping(path = "/register", consumes = "application/json")
    public ResponseEntity<ApiResponse<Map<String, Object>>> register(
            @Valid @RequestBody RegisterRequest registerRequest,
            HttpServletRequest request) {

        logger.info("Registration attempt for email='{}'", registerRequest.getEmail());

        // Letting the exceptions propagate to GlobalExceptionHandler for error cases
        Customer savedCustomer = authService.register(
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getBalance()
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/account/{id}")
                .buildAndExpand(savedCustomer.getId())
                .toUri();

        Map<String, Object> payload = Map.of("id", savedCustomer.getId());

        ApiResponse<Map<String, Object>> body = ApiResponse.success(
                201,
                "Successfully registered",
                request.getRequestURI(),
                payload
        );

        logger.info("User registered successfully: email='{}', id={}", savedCustomer.getEmail(), savedCustomer.getId());

        return ResponseEntity.created(location).body(body);
    }

    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest == null ? null : loginRequest.get("email");
        String password = loginRequest == null ? null : loginRequest.get("password");

        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            logger.warn("Login attempt with missing credentials");
            return ResponseEntity.badRequest().body(Map.of("error", "Both 'email' and 'password' must be provided"));
        }

        logger.info("Authentication attempt for email='{}'", email);
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
            Authentication auth = authenticationManager.authenticate(token);

            SecurityContextHolder.getContext().setAuthentication(auth);

            String jwt = authService.generateToken(email);

            logger.info("Authentication successful for email='{}'", email);
            return ResponseEntity.ok(Map.of("token", jwt));
        } catch (AuthenticationException ex) {
            logger.warn("Authentication failed for email='{}': {}", email, ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
        } catch (Exception ex) {
            logger.error("Unexpected error during authentication for email='{}': {}", email, ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Authentication failed due to an internal error"));
        }
    }

    @GetMapping(path = "/account", produces = "application/json")
    public ResponseEntity<?> getAccount() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getName() == null) {
            logger.warn("Unauthorized attempt to access /auth/account");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Unauthenticated"));
        }

        String email = authentication.getName();
        logger.debug("Fetching account details for email='{}'", email);

        try {
            Customer customer = authService.getCustomerDetails(email);
            if (customer == null) {
                logger.info("No account found for email='{}'", email);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Account not found"));
            }
            logger.info("Account retrieved for email='{}', id={}", customer.getEmail(), customer.getId());
            return ResponseEntity.ok(customer);
        } catch (Exception ex) {
            logger.error("Error retrieving account for email='{}': {}", email, ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Failed to retrieve account"));
        }
    }
}
