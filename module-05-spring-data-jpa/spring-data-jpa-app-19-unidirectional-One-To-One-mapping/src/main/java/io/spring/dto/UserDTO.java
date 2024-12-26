package io.spring.dto;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private UserProfileDTO profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(UserProfileDTO profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "\n✨ ==================== USER DTO ==================== ✨\n" +
                "🆔 User ID       : " + id + "\n" +
                "👤 Username      : " + username + "\n" +
                "📧 Email         : " + email + "\n" +
                "-----------------------------------------------------\n" +
                (profile != null ? profile.toString() : "📝 Profile       : No Profile Assigned ❌") +
                "\n=====================================================\n";
    }
}
