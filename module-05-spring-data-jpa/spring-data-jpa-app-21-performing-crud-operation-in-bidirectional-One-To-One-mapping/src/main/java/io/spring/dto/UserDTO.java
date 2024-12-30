package io.spring.dto;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private UserProfileDTO profile;

    // Default Constructor
    public UserDTO() {

    }

    // Parameterized Constructor
    public UserDTO(Long id, String username, String email, UserProfileDTO profile) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.profile = profile;

        if (profile != null) {
            // Maintain bi-directional consistency
            profile.setUser(this);
        }
    }

    // Getters and Setters
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

        if (profile != null) {
            // Maintain bi-directional consistency
            profile.setUser(this);
        }
    }

    @Override
    public String toString() {
        return "\n✨ ==================== USER DTO ==================== ✨\n" +
                "🆔 User ID       : " + id + "\n" +
                "👤 Username      : " + username + "\n" +
                "📧 Email         : " + email + "\n" +
                "-----------------------------------------------------\n" +
                (profile != null ? "📝 Profile Info  : \n" + profile.basicInfo() : "📝 Profile       : No Profile Assigned ❌") +
                "\n=====================================================\n";
    }

    // Helper Method for Basic Info (Avoid Recursive Calls)
    public String basicInfo() {
        return "🆔 User ID       : " + id + "\n" +
                "👤 Username      : " + username + "\n" +
                "📧 Email         : " + email + "\n";
    }
}
