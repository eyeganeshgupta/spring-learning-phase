package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Actor {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String nationality;
    private int numberOfAwards;

    // Constructor
    public Actor() {
        System.out.println("==== Actor bean created! ====");
    }

    @Value("Hrithik")
    public void setActorData(String firstName, @Value("Roshan") String lastName, @Value("50") int age, @Value("Male") String gender, @Value("Indian") String nationality, @Value("27") int numberOfAwards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.numberOfAwards = numberOfAwards;
    }

    // Method to display actor details
    public void displayDetails() {
        String border = "==========================================";
        String header = "               Actor Details              ";
        String line1 = String.format("%-20s : %s %s", "Name", firstName, lastName);
        String line2 = String.format("%-20s : %d", "Age", age);
        String line3 = String.format("%-20s : %s", "Gender", gender);
        String line4 = String.format("%-20s : %s", "Nationality", nationality);
        String line5 = String.format("%-20s : %d", "Number of Awards", numberOfAwards);

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(border);
    }

    // Method to get actor details as a formatted string
    public String getActorDetails() {
        return String.format("Name: %s %s, Age: %d, Gender: %s, Nationality: %s, Number of Awards: %d",
                firstName, lastName, age, gender, nationality, numberOfAwards);
    }
}
