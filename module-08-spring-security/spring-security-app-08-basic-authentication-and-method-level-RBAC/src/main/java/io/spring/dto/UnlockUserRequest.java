package io.spring.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to unlock a locked user account")
public class UnlockUserRequest {

    @Schema(description = "Username of the locked account", example = "lockedUser")
    private String username;

    public UnlockUserRequest() {

    }

    public UnlockUserRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
