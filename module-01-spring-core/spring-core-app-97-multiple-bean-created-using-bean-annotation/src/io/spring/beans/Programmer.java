package io.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
⭐ @Autowired Special Case
---------------------------
    ❓ What if we have multiple DevelopmentEnvironment beans? How will Spring decide which one to inject in Person?
        📢 If we have multiple DevelopmentEnvironment beans then by default Spring will not be able to pick up any particular bean for injection.
        📢 As a result it will throw ‘NoUniqueBeanDefinitionException’.
*/

@Component
public class Programmer {
    private String name;
    private int age;
    private String gender;
    private int yearsOfExperience;
    private String position;
    private double salary;
    private boolean remoteWorking;
    private DevelopmentEnvironment developmentEnvironment;

    @Autowired
    public Programmer(@Value("Ganesh Gupta") String name, @Value("21") int age,
                      @Value("Male") String gender, @Value("1") int yearsOfExperience,
                      @Value("Full Stack Web Developer") String position, @Value("400000") double salary,
                      @Value("true") boolean remoteWorking, DevelopmentEnvironment developmentEnvironment) {
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
        developmentEnvironment.displayEnvironmentDetails();
    }
}
