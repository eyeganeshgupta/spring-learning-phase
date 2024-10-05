package io.spring.service;

import io.spring.model.Student;
import io.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public int getCount() {
        return studentRepository.getCount();
    }

    public String findById(int studentId) {
        try {
            return studentRepository.findById(studentId);
        } catch (EmptyResultDataAccessException e) {
            System.err.println("Error finding student: " + e.getMessage());
            return null;
        }
    }
}
