package io.spring.repository;

import io.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveStudent(Student student) {
        String sql = "INSERT INTO Students VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int affectedRows = jdbcTemplate.update(sql,
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getGender(),
                student.getGpa(),
                student.getCreditsEarned(),
                student.getAddress(),
                student.getCity(),
                student.getState(),
                student.getZipCode(),
                student.getCountry(),
                student.getPhoneNumber(),
                student.getEmergencyContactPhone()
        );

        System.out.println("Affected Rows: " + affectedRows);
    }
}
