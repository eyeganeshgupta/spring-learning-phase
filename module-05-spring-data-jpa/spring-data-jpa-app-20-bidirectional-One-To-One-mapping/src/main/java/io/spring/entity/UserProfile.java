package io.spring.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(mappedBy = "profile") // Inverse side of the relationship
    private User user;

    // Default Constructor (Required by JPA)
    public UserProfile() {

    }

    // Parameterized Constructor
    public UserProfile(String firstName, String lastName, LocalDate birthDate) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        // Maintaining bi-directional consistency
        if (user != null && user.getProfile() != this) {
            user.setProfile(this);
        }
    }

    @Override
    public String toString() {
        return "🆔 Profile ID   : " + id + "\n" +
                "📝 First Name   : " + firstName + "\n" +
                "📝 Last Name   : " + lastName + "\n" +
                "🎂 Birth Date   : " + birthDate + "\n";
    }
}
