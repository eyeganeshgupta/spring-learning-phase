package io.spring.service.impl;

import io.spring.dto.StudentDTO;
import io.spring.entity.Course;
import io.spring.entity.Student;
import io.spring.mapper.Mapper;
import io.spring.repository.CourseRepository;
import io.spring.repository.StudentRepository;
import io.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = Mapper.toStudentEntity(studentDTO);
        return Mapper.toStudentDTO(studentRepository.save(student));
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setFirstName(studentDTO.getFirstName());
        existingStudent.setLastName(studentDTO.getLastName());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setPhoneNumber(studentDTO.getPhoneNumber());
        existingStudent.setDateOfBirth(studentDTO.getDateOfBirth());
        existingStudent.setEnrollmentDate(studentDTO.getEnrollmentDate());
        existingStudent.setIsActive(studentDTO.getIsActive());
        return Mapper.toStudentDTO(studentRepository.save(existingStudent));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(Mapper::toStudentDTO)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(Mapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    public void enrollInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Manage bidirectional relationship from owning side (student)
        student.getCourses().add(course);

        // Saving only the owning side (student), cascade will handle updates to courses if configured
        studentRepository.save(student);
    }

    public void removeFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Manage bidirectional relationship removal from owning side (student)
        student.getCourses().remove(course);

        // Saving only the owning side (student), cascade will handle updates to courses if configured
        studentRepository.save(student);
    }
}
