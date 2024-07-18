package io.spring.beans;

public class Employee {
    private String name;
    private String designation;
    private float salary;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public Employee(String designation, float salary) {
        this.designation = designation;
        this.salary = salary;
    }

    public Employee(float salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Designation: " + this.designation);
        System.out.println("Salary: " + this.salary);
    }
}
