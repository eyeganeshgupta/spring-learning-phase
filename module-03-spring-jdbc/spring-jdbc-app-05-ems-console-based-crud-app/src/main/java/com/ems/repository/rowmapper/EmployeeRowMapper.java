package com.ems.repository.rowmapper;

import com.ems.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt("employee_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setEmail(rs.getString("email"));
        employee.setPhoneNumber(rs.getString("phone_number"));
        employee.setJobTitle(rs.getString("job_title"));
        employee.setDepartment(rs.getString("department"));
        employee.setSalary(rs.getDouble("salary"));

        String genderString = rs.getString("gender");
        employee.setGender(genderString);

        employee.setAddress(rs.getString("address"));
        employee.setCity(rs.getString("city"));
        employee.setCountry(rs.getString("country"));
        employee.setPostalCode(rs.getString("postal_code"));
        employee.setEmergencyContactPhone(rs.getString("emergency_contact_phone"));

        String employmentStatusString = rs.getString("employment_status");
        employee.setEmploymentStatus(employmentStatusString);

        return employee;
    }
}
