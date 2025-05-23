package io.spring.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String gender;

    private Double salary;

    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id") // Foreign key column in Employee table
    private Department department;

    // Default constructor (required by JPA)
    public Employee() {

    }

    public Employee(Long id, String name, String email, String phone, String gender, Double salary, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salary = salary;
        this.role = role;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department; // Set the bidirectional relationship
    }

    public String toTableRow() {
        return String.format("| %-5d | %-20s | %-10s |", id, name, role);
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[ID=%d, Name='%s', Email='%s', Phone='%s', Gender='%s', Salary=%.2f, Role='%s']",
                id, name, email, phone, gender, salary, role
        );
    }
}
