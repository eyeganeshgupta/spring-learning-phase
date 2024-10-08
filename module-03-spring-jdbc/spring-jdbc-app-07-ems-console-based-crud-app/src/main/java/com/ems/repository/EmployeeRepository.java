package com.ems.repository;

import com.ems.model.Employee;
import com.ems.repository.rowmapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;
    private final EmployeeRowMapper employeeRowMapper;

    private static final String INSERT_EMPLOYEE = "INSERT INTO employees (first_name, last_name, email, phone_number, job_title, department, salary, gender, address, city, country, postal_code, emergency_contact_phone, employment_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE employee_id = ?";

    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, job_title = ?, department = ?, salary = ?, gender = ?, address = ?, city = ?, country = ?, postal_code = ?, emergency_contact_phone = ?, employment_status = ? WHERE employee_id = ?";

    private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employees WHERE employee_id = ?";

    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employees";

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeRowMapper = new EmployeeRowMapper();
    }

    public void save(Employee employee) {
        jdbcTemplate.update(INSERT_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhoneNumber(),
                employee.getJobTitle(), employee.getDepartment(), employee.getSalary(), employee.getGender(),
                employee.getAddress(), employee.getCity(), employee.getCountry(), employee.getPostalCode(),
                employee.getEmergencyContactPhone(), employee.getEmploymentStatus());
    }

    public Employee findById(int employeeId) {
        return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_ID, new Object[]{employeeId}, employeeRowMapper);
    }

    public void update(Employee employee) {
        jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhoneNumber(),
                employee.getJobTitle(), employee.getDepartment(), employee.getSalary(), employee.getGender(),
                employee.getAddress(), employee.getCity(), employee.getCountry(), employee.getPostalCode(),
                employee.getEmergencyContactPhone(), employee.getEmploymentStatus(), employee.getEmployeeId());
    }

    public void deleteById(int employeeId) {
        jdbcTemplate.update(DELETE_EMPLOYEE_BY_ID, employeeId);
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query(SELECT_ALL_EMPLOYEES, employeeRowMapper);
    }
}
