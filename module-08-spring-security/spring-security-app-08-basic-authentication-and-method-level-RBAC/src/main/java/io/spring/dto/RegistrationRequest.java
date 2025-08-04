package io.spring.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to register a new user")
public class RegistrationRequest {

    @Schema(description = "Desired username", example = "eyeganeshgupta")
    private String username;

    @Schema(description = "Password for the account", example = "P@ssw0rd123")
    private String password;

    @Schema(description = "User role to assign", example = "USER")
    private String role;

    public RegistrationRequest() {

    }

    public RegistrationRequest(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
