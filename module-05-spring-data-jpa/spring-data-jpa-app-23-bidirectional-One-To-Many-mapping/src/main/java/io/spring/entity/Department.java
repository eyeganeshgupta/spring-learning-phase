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

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
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
        for (Employee employee : employees) {
            employee.setDepartment(this); // Set bidirectional relationship
        }
    }

    // Method to add an employee to the department
    public void addEmployee(Employee employee) {
        if (employee != null) {
            employees.add(employee);
            employee.setDepartment(this); // Set bidirectional relationship
        }
    }

    // Method to remove an employee from the department
    public boolean removeEmployee(Employee employee) {
        if (employee != null && employees.contains(employee)) {
            employee.setDepartment(null); // Break bidirectional relationship
            return employees.remove(employee);
        }
        return false;
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
