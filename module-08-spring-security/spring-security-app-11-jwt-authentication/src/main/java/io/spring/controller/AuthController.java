package io.spring.controller;

import io.spring.dto.RegisterRequest;
import io.spring.model.Customer;
import io.spring.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    private AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getBalance());
        return ResponseEntity.ok("Successfully registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        String token = authService.generateToken(email);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/account")
    public ResponseEntity<Customer> getAccount() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Customer customer = authService.getCustomerDetails(email);
        return ResponseEntity.ok(customer);
    }

}
