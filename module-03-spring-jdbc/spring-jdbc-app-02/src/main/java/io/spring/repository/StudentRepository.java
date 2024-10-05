package io.spring.repository;

import io.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
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
    }

    public int getCount() {
        String sql = "SELECT COUNT(*) FROM students";
        Integer totalStudents = jdbcTemplate.queryForObject(sql, Integer.class);
        return totalStudents != null ? totalStudents : 0;
    }

    public String findById(int studentId) throws EmptyResultDataAccessException {
        String sql = "SELECT first_name FROM students WHERE student_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, studentId);
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Student not found with ID: " + studentId, 1);
        }
    }
}
