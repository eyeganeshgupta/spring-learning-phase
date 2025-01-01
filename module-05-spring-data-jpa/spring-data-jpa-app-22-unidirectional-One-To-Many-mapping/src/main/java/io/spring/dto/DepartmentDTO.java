package io.spring.dto;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String location;
    private List<EmployeeDTO> employees;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=============================================\n");
        sb.append("               DEPARTMENT DTO                \n");
        sb.append("=============================================\n");
        sb.append(String.format("| %-15s : %s\n", "ID", id));
        sb.append(String.format("| %-15s : %s\n", "Name", name));
        sb.append(String.format("| %-15s : %s\n", "Location", location));
        sb.append("---------------------------------------------\n");
        sb.append("Employees:\n");

        if (employees == null || employees.isEmpty()) {
            sb.append("  [No employees assigned]\n");
        } else {
            sb.append(String.format("| %-5s | %-20s | %-10s |\n", "ID", "Name", "Role"));
            sb.append("---------------------------------------------\n");
            for (EmployeeDTO employee : employees) {
                sb.append(employee.toTableRow()).append("\n");
            }
        }

        sb.append("=============================================\n");
        return sb.toString();
    }
}
