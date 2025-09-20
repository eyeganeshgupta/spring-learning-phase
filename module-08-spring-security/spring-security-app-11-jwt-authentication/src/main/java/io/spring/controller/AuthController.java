package io.spring.controller;

import io.spring.dto.RegisterRequest;
import io.spring.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
