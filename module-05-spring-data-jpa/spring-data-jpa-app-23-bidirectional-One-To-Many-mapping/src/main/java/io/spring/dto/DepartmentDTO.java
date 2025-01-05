package io.spring.dto;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String location;
    private List<EmployeeDTO> employees = new ArrayList<>();

    public DepartmentDTO() {

    }

    public DepartmentDTO(Long id, String name, String location, List<EmployeeDTO> employees) {
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

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    // Method to print employee details without circular dependency
    public void printSummary() {
        System.out.println("\n=============================================");
        System.out.println("               DEPARTMENT SUMMARY            ");
        System.out.println("=============================================");
        System.out.printf("| %-15s : %s\n", "ID", id);
        System.out.printf("| %-15s : %s\n", "Name", name);
        System.out.printf("| %-15s : %s\n", "Location", location);
        System.out.println("---------------------------------------------");
        System.out.println("Employees:");

        if (employees.isEmpty()) {
            System.out.println("  [No employees assigned]");
        } else {
            System.out.printf("| %-5s | %-20s | %-10s |\n", "ID", "Name", "Role");
            System.out.println("---------------------------------------------");
            for (EmployeeDTO employee : employees) {
                // Avoiding printing full department details from EmployeeDTO to prevent circular dependency
                System.out.printf("| %-5d | %-20s | %-10s |\n",
                        employee.getId(),
                        employee.getName(),
                        employee.getRole());
            }
        }

        System.out.println("=============================================");
    }

    @Override
    public String toString() {
        return String.format(
                "DepartmentDTO[ID=%d, Name='%s', Location='%s', Employees=%d]",
                id, name, location, employees.size()
        );
    }
}
