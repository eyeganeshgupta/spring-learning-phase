package io.spring.vertebrate;

import org.springframework.stereotype.Component;

@Component
public class Snake {
    private String species;
    private double length; // in meters
    private boolean venomous;
    private String habitat;
    private String diet;

    // Constructor
    public Snake() {
        System.out.println("==== Snake bean created! ====");
    }

    public Snake(String species, double length, boolean venomous, String habitat, String diet) {
        this.species = species;
        this.length = length;
        this.venomous = venomous;
        this.habitat = habitat;
        this.diet = diet;
    }

    // Getters and Setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isVenomous() {
        return venomous;
    }

    public void setVenomous(boolean venomous) {
        this.venomous = venomous;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    // Method to display snake details
    public void displayDetails() {
        String border = "==========================================";
        String header = "               Snake Details              ";
        String line1 = String.format("%-20s : %s", "Species", species);
        String line2 = String.format("%-20s : %.2f meters", "Length", length);
        String line3 = String.format("%-20s : %s", "Venomous", venomous ? "Yes" : "No");
        String line4 = String.format("%-20s : %s", "Habitat", habitat);
        String line5 = String.format("%-20s : %s", "Diet", diet);

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

    // Method to get snake details as a formatted string
    public String getSnakeDetails() {
        return String.format("Species: %s, Length: %.2f meters, Venomous: %s, Habitat: %s, Diet: %s",
                species, length, venomous ? "Yes" : "No", habitat, diet);
    }
}
