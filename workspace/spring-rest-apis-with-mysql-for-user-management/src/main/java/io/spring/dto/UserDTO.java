package io.spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotEmpty(message = "Please provide your name.")
    private String name;

    @NotEmpty(message = "Email address is required.")
    @Email(message = "Please enter a valid email address.")
    private String email;

    @NotEmpty(message = "Phone number cannot be left blank.")
    private String phoneNumber;

    @NotEmpty(message = "Gender must be specified.")
    private String gender;

    @NotEmpty(message = "Address details are necessary.")
    private String address;

    private String role;
    private String status;
}
