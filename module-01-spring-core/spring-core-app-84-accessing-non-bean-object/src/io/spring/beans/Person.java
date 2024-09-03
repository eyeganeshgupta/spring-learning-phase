package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Person {
    @Value("Ganesh")
    private String firstName;
    @Value("Gupta")
    private String lastName;
    @Value("#{new java.util.Date(103, 1, 18)}")
    // Year 2003 (1900 + 103), Month is 0-based, so February is 1
    private Date dateOfBirth;

    // Constructor to initialize the Person object
    public Person() {
        System.out.println("==== Person bean created! ====");
    }

    public Person(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for date of birth
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    // Setter for date of birth
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Method to get the formatted date of birth
    public String getFormattedDateOfBirth(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(dateOfBirth);
    }

    // Method to calculate age based on the date of birth
    public int calculateAge() {
        Date currentDate = new Date();
        long timeDifference = currentDate.getTime() - dateOfBirth.getTime();
        return (int)(timeDifference / (1000L * 60 * 60 * 24 * 365));
    }
}
