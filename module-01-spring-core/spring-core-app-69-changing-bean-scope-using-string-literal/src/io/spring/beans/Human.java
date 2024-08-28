package io.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
    ⭐ Changing Bean Scope
        👉 By default, the Spring IoC container always creates and initializes all beans as “singleton”.
        👉 However, we can define a bean's scope as prototype using @Scope annotation.

    ⭐ The @Scope Annotation
        👉 The @Scope annotation in Spring is used to define the scope of a bean in the Spring container.
        👉 This can be done in 2 ways:
            1️⃣ Using String literal
            2️⃣ Using predefined constant

    ⭐ Using String Literals
        ╰┈➤ We can use the String literals to provide value to the @Scope annotation using following syntax:
        ╰┈➤ @Scope(“…”) or @Scope(value = “…”)
        ╰┈➤ The possible values which can be given are:
            1️⃣ “singleton”: Single instance per Spring container (default).
            2️⃣ “prototype”: New instance per request
            3️⃣ “request”: New instance per HTTP request (web).
            4️⃣ “session”: New instance per HTTP session (web).
            5️⃣ “application”: Single instance per ServletContext (web).
            6️⃣ “websocket”: New instance per WebSocket session (web).
*/

@Component
@Scope(value = "prototype")
public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private double height; // in centimeters
    private double weight; // in kilograms

    // Constructor
    public Human() {
        System.out.println("==== Human bean created! ====");
    }

    public Human(String firstName, String lastName, int age, String gender, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Method to display human details
    public void displayDetails() {
        String border = "==========================================";
        String header = "               Human Details              ";
        String line1 = String.format("%-20s : %s %s", "Name", firstName, lastName);
        String line2 = String.format("%-20s : %d", "Age", age);
        String line3 = String.format("%-20s : %s", "Gender", gender);
        String line4 = String.format("%-20s : %.2f cm", "Height", height);
        String line5 = String.format("%-20s : %.2f kg", "Weight", weight);

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

    // Method to get human details as a formatted string
    public String getHumanDetails() {
        return String.format("Name: %s %s, Age: %d, Gender: %s, Height: %.2f cm, Weight: %.2f kg",
                firstName, lastName, age, gender, height, weight);
    }
}
