package io.spring.beans;

import java.util.Date;

public class Student {
    // Properties
    private String name;
    private int studentId;
    private String email;
    private Date dateOfBirth;

    // Constructor
    public Student(String name, int studentId, String email, Date dateOfBirth) {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
