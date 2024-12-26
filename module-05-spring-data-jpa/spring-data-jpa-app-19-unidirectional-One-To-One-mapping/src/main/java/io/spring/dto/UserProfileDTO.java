package io.spring.dto;

import java.time.LocalDate;

public class UserProfileDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

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

    @Override
    public String toString() {
        return "🆔 Profile ID   : " + id + "\n" +
                "📝 First Name   : " + firstName + "\n" +
                "📝 Last Name    : " + lastName + "\n" +
                "🎂 Birth Date   : " + birthDate + "\n";
    }
}
