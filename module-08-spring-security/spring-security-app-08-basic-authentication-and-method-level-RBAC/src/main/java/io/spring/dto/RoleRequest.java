package io.spring.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to change a user's role")
public class RoleRequest {

    @Schema(description = "Username of the target user", example = "eyeganeshgupta")
    private String username;

    @Schema(description = "New role to assign", example = "ADMIN")
    private String newRole;

    public RoleRequest() {

    }

    public RoleRequest(String username, String newRole) {
        this.username = username;
        this.newRole = newRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewRole() {
        return newRole;
    }

    public void setNewRole(String newRole) {
        this.newRole = newRole;
    }
}
