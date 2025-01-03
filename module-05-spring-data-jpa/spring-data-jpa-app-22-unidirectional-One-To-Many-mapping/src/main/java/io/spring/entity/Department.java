package io.spring.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id") // Foreign key column in Employee table
    private List<Employee> employees = new ArrayList<>();

    // Default constructor (required by JPA)
    public Department() {

    }

    public Department(Long id, String name, String location, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employees = employees;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // Method to add an employee to the employees list
    public void addEmployee(Employee employee) {
        if (employee != null) { // Check for null to avoid NullPointerException
            employees.add(employee);
        }
    }

    // Method to remove an employee from the employees list by Employee object
    public boolean removeEmployee(Employee employee) {
        if (employee != null && employees.contains(employee)) {
            return employees.remove(employee); // Removes the specific Employee object
        }
        return false; // Returning false if the employee is null or not found
    }

    // Method to remove an employee from the employees list by Employee ID
    public boolean removeEmployeeById(Long employeeId) {
        if (employeeId != null) {
            for (Employee emp : employees) {
                if (emp.getId().equals(employeeId)) { // Match employee by ID
                    employees.remove(emp);
                    return true; // Successfully removed
                }
            }
        }
        return false; // Returning false if no matching employee is found
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=============================================\n");
        sb.append("               DEPARTMENT DETAILS            \n");
        sb.append("=============================================\n");
        sb.append(String.format("| %-15s : %s\n", "ID", id));
        sb.append(String.format("| %-15s : %s\n", "Name", name));
        sb.append(String.format("| %-15s : %s\n", "Location", location));
        sb.append("---------------------------------------------\n");
        sb.append("Employees:\n");

        if (employees.isEmpty()) {
            sb.append("  [No employees assigned]\n");
        } else {
            sb.append(String.format("| %-5s | %-20s | %-10s |\n", "ID", "Name", "Role"));
            sb.append("---------------------------------------------\n");
            for (Employee employee : employees) {
                sb.append(employee.toTableRow()).append("\n");
            }
        }

        sb.append("=============================================\n");
        return sb.toString();
    }
}
