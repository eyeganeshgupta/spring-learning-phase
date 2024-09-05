package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Actor {
    @Value("${actor.firstName}")
    private String firstName;
    @Value("${actor.lastName}")
    private String lastName;
    @Value("${actor.age}")
    private int age;
    @Value("${actor.gender}")
    private String gender;
    @Value("${actor.nationality}")
    private String nationality;
    @Value("${actor.numberOfAwards}")
    private int numberOfAwards;
    /*
        ⭐ Accessing LinkedList
            👉 We know that by default Spring converts List values to ArrayList when reading the data from properties file.
            👉 In case our bean has a LinkedList as its instance member then we will have to explicitly convert these values to LinkedList which is done by using LinkedList constructor and Array.asList() method.
    */
    @Value("#{new java.util.LinkedList(T(java.util.Arrays).asList('${actor.famousMovies}'))}")
    private List<String> famousMovies;

    // Constructor
    public Actor() {
        System.out.println("==== Actor bean created! ====");
    }

    public Actor(String firstName, String lastName, int age, String gender, String nationality, int numberOfAwards, List<String> famousMovies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.numberOfAwards = numberOfAwards;
        this.famousMovies = famousMovies;

        System.out.println("==== Actor bean created! ====");
    }

    // Method to display actor details
    public void displayDetails() {
        System.out.println("famousMovies type: " + famousMovies.getClass().getName());
        String border = "==========================================";
        String header = "               Actor Details              ";
        String line1 = String.format("%-20s : %s %s", "Name", firstName, lastName);
        String line2 = String.format("%-20s : %d", "Age", age);
        String line3 = String.format("%-20s : %s", "Gender", gender);
        String line4 = String.format("%-20s : %s", "Nationality", nationality);
        String line5 = String.format("%-20s : %d", "Number of Awards", numberOfAwards);
        String line6 = String.format("%-20s : %s", "Famous Movies", famousMovies.toString());

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(border);
    }

    // Method to get actor details as a formatted string
    public String getActorDetails() {
        return String.format("Name: %s %s, Age: %d, Gender: %s, Nationality: %s, Number of Awards: %d, Famous Movies: %s",
                firstName, lastName, age, gender, nationality, numberOfAwards, famousMovies.toString());
    }
}
