package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
    @Value("${actor.famousMovies}")
    private List<String> famousMovies;
    /*
        👉 We can read List values from properties file by directly passing ${...} in @Value() annotation but we cannot do this for Map.
        👉 So for reading Map values from properties file we need to use “SpEL” with the following syntax:
            ╰┈➤ @Value("#{${...}}")
    */
    @Value("#{${actor.movieAwards}}")
    private Map<String, Integer> movieAwards;

    // Constructor
    public Actor() {
        System.out.println("==== Actor bean created! ====");
    }

    public Actor(String firstName, String lastName, int age, String gender, String nationality, int numberOfAwards, List<String> famousMovies, Map<String, Integer> movieAwards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.numberOfAwards = numberOfAwards;
        this.famousMovies = famousMovies;
        this.movieAwards = movieAwards;
        System.out.println("==== Actor bean created! ====");
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getNumberOfAwards() {
        return numberOfAwards;
    }

    public void setNumberOfAwards(int numberOfAwards) {
        this.numberOfAwards = numberOfAwards;
    }

    public List<String> getFamousMovies() {
        return famousMovies;
    }

    public void setFamousMovies(List<String> famousMovies) {
        this.famousMovies = famousMovies;
    }

    public Map<String, Integer> getMovieAwards() {
        return movieAwards;
    }

    public void setMovieAwards(Map<String, Integer> movieAwards) {
        this.movieAwards = movieAwards;
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

        // Display movie awards
        System.out.println("Movie Awards:");
        for (Map.Entry<String, Integer> entry : movieAwards.entrySet()) {
            System.out.printf("%-20s : %d Awards%n", entry.getKey(), entry.getValue());
        }

        System.out.println(border);
    }

    // Method to get actor details as a formatted string
    public String getActorDetails() {
        return String.format("Name: %s %s, Age: %d, Gender: %s, Nationality: %s, Number of Awards: %d, Famous Movies: %s, Movie Awards: %s",
                firstName, lastName, age, gender, nationality, numberOfAwards,
                String.join(", ", famousMovies), movieAwards.toString());
    }
}
