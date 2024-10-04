package io.spring.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private double gpa;
    private int creditsEarned;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phoneNumber;
    private String emergencyContactPhone;

    public Student() {
        System.out.println("Student model created");
    }

    /*
    public Student(int studentId, String firstName, String lastName, String email, String gender,
                   double gpa, int creditsEarned, String address, String city, String state,
                   String zipCode, String country, String phoneNumber, String emergencyContactPhone) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.gpa = gpa;
        this.creditsEarned = creditsEarned;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.emergencyContactPhone = emergencyContactPhone;
    }
    */

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(int creditsEarned) {
        this.creditsEarned = creditsEarned;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    @Override
    public String toString() {
        return String.format(
                "Student Profile\n" +
                        "================\n" +
                        "ID: %d\n" +
                        "Name: %s %s\n" +
                        "Email: %s\n" +
                        "Gender: %s\n" +
                        "GPA: %.2f\n" +
                        "Credits Earned: %d\n" +
                        "\n" +
                        "Contact Information\n" +
                        "--------------------\n" +
                        "Address: %s\n" +
                        "         %s, %s %s\n" +
                        "         %s\n" +
                        "Phone: %s\n" +
                        "Emergency Contact: %s",
                studentId,
                firstName, lastName,
                email,
                gender,
                gpa,
                creditsEarned,
                address,
                city, state, zipCode,
                country,
                phoneNumber,
                emergencyContactPhone
        );
    }
}