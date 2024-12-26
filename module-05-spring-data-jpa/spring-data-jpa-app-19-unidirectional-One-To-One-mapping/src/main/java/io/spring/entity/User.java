package io.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", unique = true)
    private UserProfile profile;

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

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "\n✨ ==================== USER DETAILS ==================== ✨\n" +
                "🆔 User ID       : " + id + "\n" +
                "👤 Username      : " + username + "\n" +
                "📧 Email         : " + email + "\n" +
                "---------------------------------------------------------\n" +
                (profile != null ? profile.toString() : "📝 Profile       : No Profile Assigned ❌") +
                "\n=========================================================\n";
    }
}
