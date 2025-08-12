package io.spring.controller;

import io.spring.dto.RegistrationRequest;
import io.spring.response.ApiResponse;
import io.spring.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication Controller", description = "Handles user registration and authentication")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService registrationService;

    public AuthController(AuthService registrationService) {
        this.registrationService = registrationService;
    }

    @Operation(
            summary = "Register a new user",
            description = "Creates a new user account with username, password, and role"
    )
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> registerUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Registration details including username, password, and role",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Registration",
                                    summary = "Registration request",
                                    value = "{ \"username\": \"eyeganeshgupta\", \"password\": \"StrongP@ss123\", \"role\": \"USER\" }"
                            )
                    )
            )
            @RequestBody RegistrationRequest request) {
        try {
            String message = registrationService.registerUser(request);
            ApiResponse<String> response = new ApiResponse<>(true, message, null);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            ApiResponse<String> response = new ApiResponse<>(false, ex.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
