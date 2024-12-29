package io.spring.dto;

import java.time.LocalDate;

public class UserProfileDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private UserDTO user; // Reference back to UserDTO

    // Default Constructor
    public UserProfileDTO() {

    }

    // Parameterized Constructor
    public UserProfileDTO(Long id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;

        if (user != null && user.getProfile() != this) {
            // Maintain bi-directional consistency
            user.setProfile(this);
        }
    }

    @Override
    public String toString() {
        return "🆔 Profile ID   : " + id + "\n" +
                "📝 First Name   : " + firstName + "\n" +
                "📝 Last Name   : " + lastName + "\n" +
                "🎂 Birth Date   : " + birthDate + "\n" +
                "-----------------------------------------------------\n" +
                (user != null ? "👤 Associated User: \n" + user.basicInfo() : "👤 Associated User: None ❌") +
                "\n=====================================================\n";
    }
}
