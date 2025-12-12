package io.spring.controller;

import io.spring.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

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

}
