package io.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;

    // Constructor
    public Car() {
        System.out.println("Car non-parameterized constructor");
    }

    public Car(String make, String model, int year, String color, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        System.out.println("Car with 5 parameter constructor");
    }

    // Setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Action: Start the car
    @PostConstruct
    public void start() {
        System.out.println("The car is now starting.");
    }

    // Action: Drive the car
    public void drive() {
        System.out.println("The car is now driving.");
    }

    // Action: Turn on the headlights
    public void turnOnHeadlights() {
        System.out.println("Headlights are on.");
    }

    // Action: Play music from the car's audio system
    public void playMusic(String songTitle) {
        System.out.println("Playing: " + songTitle);
    }

    // Action: Stop the car
    @PreDestroy
    public void stop() {
        System.out.println("The car has stopped.");
    }

    // Action: Apply a discount to the car price
    public void applyDiscount(double discount) {
        if (discount > 0 && discount <= 100) {
            price -= price * (discount / 100);
            System.out.printf("A discount of %.2f%% has been applied. New price: $%.2f%n", discount, price);
        } else {
            System.out.println("Invalid discount percentage. Please enter a value between 0 and 100.");
        }
    }

    // Method to display car details in a decorative manner
    public void displayDetails() {
        String border = "==========================================";
        String header = "                Car Details               ";
        String line1 = String.format("%-20s : %s", "Make", make);
        String line2 = String.format("%-20s : %s", "Model", model);
        String line3 = String.format("%-20s : %d", "Year", year);
        String line4 = String.format("%-20s : %s", "Color", color);
        String line5 = String.format("%-20s : $%.2f", "Price", price);

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

    // Method to get car details as a formatted string
    public String getCarDetails() {
        return String.format("Make: %s, Model: %s, Year: %d, Color: %s, Price: $%.2f",
                make, model, year, color, price);
    }
}
