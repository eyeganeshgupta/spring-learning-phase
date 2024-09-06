package io.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Driver {
    @Value("Ganesh Gupta")
    private String name;
    @Value("21")
    private int age;
    @Value("Male")
    private String gender;
    @Autowired
    private License license;

    // Constructor
    public Driver() {
        System.out.println("==== Driver bean created! ====");
    }

    public Driver(String name, int age, String gender, License license) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.license = license;
        System.out.println("==== Driver bean created! ====");
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    // Method to display driver details
    public void displayDriverDetails() {
        String border = "==========================================";
        String header = "               Driver Details             ";
        String line1 = String.format("%-20s : %s", "Name", name);
        String line2 = String.format("%-20s : %d", "Age", age);
        String line3 = String.format("%-20s : %s", "Gender", gender);

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        System.out.println("License Information:");
        license.displayLicenseDetails(); // Display the license details of the driver
        System.out.println(border);
    }
}
