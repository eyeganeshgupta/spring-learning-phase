package io.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private String firstName;
    private String lastName;
    private int employeeId;
    private String department;
    private String position;
    private double salary;

    // Constructor
    public Employee() {
        System.out.println("==== Employee bean created! ====");
    }

    public Employee(String firstName, String lastName, int employeeId, String department, String position, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.salary = salary;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    // Method to display employee details
    public void displayDetails() {
        String border = "==========================================";
        String header = "               Employee Details            ";
        String line1 = String.format("%-20s : %s %s", "Name", firstName, lastName);
        String line2 = String.format("%-20s : %d", "Employee ID", employeeId);
        String line3 = String.format("%-20s : %s", "Department", department);
        String line4 = String.format("%-20s : %s", "Position", position);
        String line5 = String.format("%-20s : $%.2f", "Salary", salary);

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

    // Method to get employee details as a formatted string
    public String getEmployeeDetails() {
        return String.format("Name: %s %s, Employee ID: %d, Department: %s, Position: %s, Salary: $%.2f",
                firstName, lastName, employeeId, department, position, salary);
    }
}
