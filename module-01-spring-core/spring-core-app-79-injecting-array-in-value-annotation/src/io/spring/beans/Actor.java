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
    private String[] famousMovies;

    // Constructor
    public Actor(@Value("${actor.firstName}") String firstName, @Value("${actor.lastName}") String lastName, @Value("${actor.age}") int age, @Value("${actor.gender}") String gender, @Value("${actor.nationality}") String nationality, @Value("${actor.numberOfAwards}") int numberOfAwards, @Value("${actor.famousMovies}") String[] famousMovies) {
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
        String border = "==========================================";
        String header = "               Actor Details              ";
        String line1 = String.format("%-20s : %s %s", "Name", firstName, lastName);
        String line2 = String.format("%-20s : %d", "Age", age);
        String line3 = String.format("%-20s : %s", "Gender", gender);
        String line4 = String.format("%-20s : %s", "Nationality", nationality);
        String line5 = String.format("%-20s : %d", "Number of Awards", numberOfAwards);
        String line6 = String.format("%-20s : %s", "Famous Movies", String.join(", ", famousMovies));

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
                firstName, lastName, age, gender, nationality, numberOfAwards, String.join(", ", famousMovies));
    }
}
