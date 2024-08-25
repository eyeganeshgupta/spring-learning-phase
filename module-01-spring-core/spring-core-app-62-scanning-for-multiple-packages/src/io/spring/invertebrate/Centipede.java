package io.spring.invertebrate;

import org.springframework.stereotype.Component;

@Component
public class Centipede {
    private String species;
    private double length; // in centimeters
    private int numberOfLegs;
    private String habitat;
    private String diet;

    // Constructor
    public Centipede() {
        System.out.println("==== Centipede bean created! ====");
    }

    public Centipede(String species, double length, int numberOfLegs, String habitat, String diet) {
        this.species = species;
        this.length = length;
        this.numberOfLegs = numberOfLegs;
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

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
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

    // Method to display centipede details
    public void displayDetails() {
        String border = "==========================================";
        String header = "              Centipede Details           ";
        String line1 = String.format("%-20s : %s", "Species", species);
        String line2 = String.format("%-20s : %.2f cm", "Length", length);
        String line3 = String.format("%-20s : %d", "Number of Legs", numberOfLegs);
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

    // Method to get centipede details as a formatted string
    public String getCentipedeDetails() {
        return String.format("Species: %s, Length: %.2f cm, Number of Legs: %d, Habitat: %s, Diet: %s",
                species, length, numberOfLegs, habitat, diet);
    }
}
