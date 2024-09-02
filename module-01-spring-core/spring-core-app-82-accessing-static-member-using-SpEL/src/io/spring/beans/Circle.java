package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle {
    @Value("#{T(java.lang.Math).PI}")
    private double PI;
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double radius;

    // Constructor
    public Circle() {
        System.out.println("==== Circle bean created! ====");
    }

    // Getter and Setter for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double calculateArea() {
        return PI * radius * radius;
    }

    // Method to calculate the circumference of the circle
    public double calculateCircumference() {
        return 2 * PI * radius;
    }

    // Method to display circle details
    public void displayDetails() {
        System.out.println("\nCircle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
}
