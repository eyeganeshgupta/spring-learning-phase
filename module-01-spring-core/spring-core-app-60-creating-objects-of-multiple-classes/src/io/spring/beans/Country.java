package io.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Country {
    private String name;
    private String capital;
    private long population;
    private double area; // in square kilometers
    private String currency;

    // Constructor
    public Country() {
        System.out.println("==== Country bean created! ====");
    }

    public Country(String name, String capital, long population, double area, String currency) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.currency = currency;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Method to display country details
    public void displayDetails() {
        String border = "==========================================";
        String header = "               Country Details            ";
        String line1 = String.format("%-20s : %s", "Name", name);
        String line2 = String.format("%-20s : %s", "Capital", capital);
        String line3 = String.format("%-20s : %,d", "Population", population);
        String line4 = String.format("%-20s : %.2f km²", "Area", area);
        String line5 = String.format("%-20s : %s", "Currency", currency);

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

    // Method to get country details as a formatted string
    public String getCountryDetails() {
        return String.format("Name: %s, Capital: %s, Population: %,d, Area: %.2f km², Currency: %s",
                name, capital, population, area, currency);
    }
}
