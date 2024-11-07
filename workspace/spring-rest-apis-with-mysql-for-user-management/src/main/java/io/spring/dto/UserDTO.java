package io.spring.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Data Transfer Object representing a user in the system, containing user-related information."
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Schema(
            description = "Unique identifier for the user. This field is auto-generated and should not be provided during user creation."
    )
    private Long id;

    @Schema(
            description = "The full name of the user. This field is required and cannot be empty."
    )
    @NotEmpty(message = "Please provide your name.")
    private String name;

    @Schema(
            description = "The email address of the user. This field is required and must be a valid email format."
    )
    @NotEmpty(message = "Email address is required.")
    @Email(message = "Please enter a valid email address.")
    private String email;

    @Schema(
            description = "The phone number of the user. This field is required and cannot be empty."
    )
    @NotEmpty(message = "Phone number cannot be left blank.")
    private String phoneNumber;

    @Schema(
            description = "The gender of the user. This field is required and must be specified."
    )
    @NotEmpty(message = "Gender must be specified.")
    private String gender;

    @Schema(
            description = "The residential address of the user. This field is required and cannot be empty."
    )
    @NotEmpty(message = "Address details are necessary.")
    private String address;

    @Schema(
            description = "The role assigned to the user within the system. Default is 'USER' for new users."
    )
    private String role;

    @Schema(
            description = "The current status of the user account, e.g., 'ACTIVE', 'INACTIVE'. Default is 'ACTIVE' for new users."
    )
    private String status;
}
