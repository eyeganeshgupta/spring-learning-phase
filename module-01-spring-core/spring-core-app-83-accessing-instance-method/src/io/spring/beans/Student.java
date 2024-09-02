package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("#{generateRandomNumber.generateRandomNumber(6)}")
    private String studentId;
    @Value("Ganesh")
    private String firstName;
    @Value("Gupta")
    private String lastName;
    @Value("21")
    private int age;

    // Constructor
    public Student() {
        System.out.println("==== Student bean created! ====");
    }

    // Method to display student details
    public void displayDetails() {
        String border = "==========================================";
        String header = "               Student Details            ";
        String line1 = String.format("%-20s : %s", "Student ID", studentId);
        String line2 = String.format("%-20s : %s %s", "Name", firstName, lastName);
        String line3 = String.format("%-20s : %d", "Age", age);

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(border);
    }
}
