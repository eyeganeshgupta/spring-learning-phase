package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
⭐ Lazy Initialization
---------------------
    👉 By default, Spring performs eager initialization of Singleton bean when the application context is loaded.
    👉 However, by enabling lazy initialization, a bean can be created only when it's requested.
    👉 To achieve lazy initialization in Spring, we can use the @Lazy annotation.
    👉 This can be applied at both the ‘class level’ and the ‘method level’ (for @Bean methods).
*/

/*
⭐ Using @Lazy at Class Level
-------------------------------
    1️⃣ When we annotate a component with @Lazy, then Spring will delay the creation of that bean until it is first requested.
    2️⃣ The term requested means ‘injected’ or ‘accessed’.
*/

/*
⭐ Using @Lazy at Method Level
-------------------------------
    1️⃣ We can also make specific beans defined in a @Configuration class lazy by applying @Lazy on the method.
*/

public class PanCard {
    @Value("GANES3271G")
    private String panNumber;
    @Value("Ganesh")
    private String firstName;
    @Value("Gupta")
    private String lastName;
    @Value("Ashish")
    private String fatherName;
    @Value("18/02/2003")
    private String dateOfBirth;

    // Constructor
    public PanCard() {
        System.out.println("==== PanCard bean created! ====");
    }

    public PanCard(String panNumber, String firstName, String lastName, String fatherName, String dateOfBirth) {
        this.panNumber = panNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        System.out.println("==== PanCard bean created! ====");
    }

    // Getters and Setters
    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Method to display PanCard details
    public void displayDetails() {
        String border = "==========================================";
        String header = "              PanCard Details             ";
        String line1 = String.format("%-20s : %s", "Pan Number", panNumber);
        String line2 = String.format("%-20s : %s %s", "Name", firstName, lastName);
        String line3 = String.format("%-20s : %s", "Father's Name", fatherName);
        String line4 = String.format("%-20s : %s", "Date of Birth", dateOfBirth);

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(border);
    }
}
