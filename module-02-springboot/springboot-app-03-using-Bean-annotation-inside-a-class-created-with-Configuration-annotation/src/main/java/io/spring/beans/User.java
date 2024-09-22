package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    // Identity Information
    private String firstName;
    private String lastName;
    private String username;

    // Contact Information
    private String email;
    private String phoneNumber;
    private String address;

    // Personal Information
    private int age;
    private String gender;

    // Security Information
    private char[] password;
    private boolean isVerified;

    // Constructor
    public User(@Value("Ganesh") String firstName, @Value("Gupta") String lastName, @Value("eyeganeshgupta") String username, @Value("eyeganeshgupta@gmail.com") String email, @Value("+91 89839 71752") String phoneNumber, @Value("Mumbai, India") String address,
                @Value("21") int age, @Value("Male") String gender, @Value("#{new java.lang.String('ganesh').toCharArray()}") char[] password, @Value("true") boolean isVerified) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.password = password.clone(); // Clone to avoid exposing the original array
        this.isVerified = isVerified;
        System.out.println("==== User bean created! ====");
    }

    // Getters and Setters
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public char[] getPassword() {
        return password.clone(); // Return a clone to avoid exposing the original array
    }

    public void setPassword(char[] password) {
        this.password = password.clone(); // Clone to avoid exposing the original array
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    // Method to display user details
    public void displayUserDetails() {
        System.out.println("==========================================");
        System.out.println("User Details");
        System.out.println("==========================================");
        System.out.println("Name          : " + firstName + " " + lastName);
        System.out.println("Username      : " + username);
        System.out.println("Email         : " + email);
        System.out.println("Phone Number  : " + phoneNumber);
        System.out.println("Address       : " + address);
        System.out.println("Age           : " + age);
        System.out.println("Gender        : " + gender);
        System.out.println("Verified User : " + (isVerified ? "Yes" : "No"));
        System.out.println("==========================================");
    }
}
