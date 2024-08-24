package io.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class State {
    private String name;
    private String capital;
    private long population;
    private double area; // in square kilometers
    private String country;

    // Constructor
    public State() {
        System.out.println("==== State bean created! ====");
    }

    public State(String name, String capital, long population, double area, String country) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.country = country;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Method to display state details
    public void displayDetails() {
        String border = "==========================================";
        String header = "                State Details              ";
        String line1 = String.format("%-20s : %s", "Name", name);
        String line2 = String.format("%-20s : %s", "Capital", capital);
        String line3 = String.format("%-20s : %,d", "Population", population);
        String line4 = String.format("%-20s : %.2f km²", "Area", area);
        String line5 = String.format("%-20s : %s", "Country", country);

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

    // Method to get state details as a formatted string
    public String getStateDetails() {
        return String.format("Name: %s, Capital: %s, Population: %,d, Area: %.2f km², Country: %s",
                name, capital, population, area, country);
    }
}
