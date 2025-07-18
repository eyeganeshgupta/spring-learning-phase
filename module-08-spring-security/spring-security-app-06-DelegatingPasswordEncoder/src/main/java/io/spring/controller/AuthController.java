package io.spring.controller;

import io.spring.constants.MessageConstants;
import io.spring.dto.CustomerDTO;
import io.spring.response.ApiResponse;
import io.spring.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CustomerService customerService;

    public AuthController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> registerCustomer(@RequestBody CustomerDTO customerDTO) {
        return handleRegistration(() -> customerService.registerCustomer(customerDTO));
    }

    @PostMapping("/register/noop")
    public ResponseEntity<ApiResponse<String>> registerCustomerNoOp(@RequestBody CustomerDTO customerDTO) {
        return handleRegistration(() -> customerService.registerCustomerNoOp(customerDTO));
    }

    private ResponseEntity<ApiResponse<String>> handleRegistration(RegistrationStrategy strategy) {
        try {
            String result = strategy.register();

            if (MessageConstants.EMAIL_ALREADY_EXISTS.equalsIgnoreCase(result)) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(new ApiResponse<>(false, MessageConstants.REGISTRATION_FAILED, result));
            }

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, MessageConstants.REGISTRATION_SUCCESS, result));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, MessageConstants.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }

    @FunctionalInterface
    private interface RegistrationStrategy {
        String register();
    }

}
