package io.spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "First name is required and must not be blank.")
    @Size(min = 2, max = 50, message = "First name must contain between 2 and 50 characters.")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ '-]+$", message = "First name can contain only letters, spaces, hyphens, and apostrophes.")
    private String firstName;

    @NotBlank(message = "Last name is required and must not be blank.")
    @Size(min = 2, max = 50, message = "Last name must contain between 2 and 50 characters.")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ '-]+$", message = "Last name can contain only letters, spaces, hyphens, and apostrophes.")
    private String lastName;

    @NotBlank(message = "Email address is required.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotBlank(message = "Password is required and must not be blank.")
    @Size(min = 8, max = 100, message = "Password must be at least 8 and at most 100 characters in length.")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=[\\]{};':\"\\\\|,.<>/?]).{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character."
    )
    private String password;

    @PositiveOrZero(message = "Balance must be zero or a positive value.")
    private double balance;
}
