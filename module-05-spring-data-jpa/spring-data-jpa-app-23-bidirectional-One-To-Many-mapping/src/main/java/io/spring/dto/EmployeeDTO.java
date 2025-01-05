package io.spring.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private Double salary;
    private String role;

    // Reference to the parent department (only the ID to avoid circular references)
    private Long departmentId;

    public EmployeeDTO() {

    }

    public EmployeeDTO(Long id, String name, String email, String phone, String gender, Double salary, String role, Long departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salary = salary;
        this.role = role;
        this.departmentId = departmentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId; // Reference to the parent department
    }

    public String toTableRow() {
        return String.format("| %-5d | %-20s | %-10s |", id, name, role);
    }

    // Method to print employee details without circular dependency
    public void printSummary() {
        System.out.println("\n=============================================");
        System.out.println("               EMPLOYEE SUMMARY              ");
        System.out.println("=============================================");
        System.out.printf("| %-15s : %s\n", "ID", id);
        System.out.printf("| %-15s : %s\n", "Name", name);
        System.out.printf("| %-15s : %s\n", "Email", email);
        System.out.printf("| %-15s : %s\n", "Phone", phone);
        System.out.printf("| %-15s : %s\n", "Gender", gender);
        System.out.printf("| %-15s : %.2f\n", "Salary", salary);
        System.out.printf("| %-15s : %s\n", "Role", role);
        System.out.printf("| %-15s : %s\n", "Department ID", departmentId); // Avoid full department details
        System.out.println("=============================================");
    }

    @Override
    public String toString() {
        return String.format(
                "EmployeeDTO[ID=%d, Name='%s', Email='%s', Phone='%s', Gender='%s', Salary=%.2f, Role='%s', DepartmentID=%d]",
                id, name, email, phone, gender, salary, role, departmentId
        );
    }
}
