package io.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
⭐ @Autowired Special Case
---------------------
    👉 If all the constructors are parameterized then we must designate any one constructor with the @Autowired annotation otherwise Spring will throw the exception called BeanCreationException.
*/

@Component
public class Programmer {
    @Value("Ganesh Gupta")
    private String name;
    @Value("21")
    private int age;
    @Value("Male")
    private String gender;
    @Value("1")
    private int yearsOfExperience;
    @Value("Full Stack Web Developer")
    private String position;
    @Value("400000")
    private double salary;
    @Value("true")
    private boolean remoteWorking;
    private DevelopmentEnvironment developmentEnvironment;

    // ⚡ Since all constructors are parameterized and @Autowired is missing Spring will throw BeanCreationException.
    public Programmer(DevelopmentEnvironment developmentEnvironment) {
        this.developmentEnvironment = developmentEnvironment;
        System.out.println("==== Programmer bean created! ====");
    }

    public Programmer(String name, int age, String gender, int yearsOfExperience, String position, double salary,
                      boolean remoteWorking, DevelopmentEnvironment developmentEnvironment) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.yearsOfExperience = yearsOfExperience;
        this.position = position;
        this.salary = salary;
        this.remoteWorking = remoteWorking;
        this.developmentEnvironment = developmentEnvironment;
        System.out.println("==== Programmer bean created! ====");
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

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isRemoteWorking() {
        return remoteWorking;
    }

    public void setRemoteWorking(boolean remoteWorking) {
        this.remoteWorking = remoteWorking;
    }

    public DevelopmentEnvironment getDevelopmentEnvironment() {
        return developmentEnvironment;
    }

    public void setDevelopmentEnvironment(DevelopmentEnvironment developmentEnvironment) {
        this.developmentEnvironment = developmentEnvironment;
    }

    // Method to display programmer details
    public void displayProgrammerDetails() {
        String border = "==========================================";
        String header = "            Programmer Details            ";
        String line1 = String.format("%-20s : %s", "Name", name);
        String line2 = String.format("%-20s : %d", "Age", age);
        String line3 = String.format("%-20s : %s", "Gender", gender);
        String line4 = String.format("%-20s : %d years", "Experience", yearsOfExperience);
        String line5 = String.format("%-20s : %s", "Position", position);
        String line6 = String.format("%-20s : %.2f", "Salary", salary);
        String line7 = String.format("%-20s : %s", "Remote Working", remoteWorking ? "Yes" : "No");

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);

        System.out.println("\nDevelopment Environment:");
        developmentEnvironment.displayEnvironmentDetails();  // Display development environment details
    }
}
