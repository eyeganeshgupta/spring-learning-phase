package io.spring.service;

import io.spring.dto.CourseDTO;
import io.spring.dto.StudentDTO;
import io.spring.entity.Course;
import io.spring.entity.Student;
import io.spring.repository.CourseRepository;
import io.spring.repository.StudentRepository;
import io.spring.mapper.StudentMapper;
import io.spring.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCourseService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentCourseService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Add a new course
    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course courseEntity = CourseMapper.toCourseEntity(courseDTO);
        Course savedCourse = courseRepository.save(courseEntity);
        return CourseMapper.toCourseDTO(savedCourse);
    }

    // Add a new student
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student studentEntity = StudentMapper.toStudentEntity(studentDTO);
        Student savedStudent = studentRepository.save(studentEntity);
        return StudentMapper.toStudentDTO(savedStudent);
    }

    // Enroll a student in a course
    public String enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student == null || course == null) {
            return "Student or Course not found!";
        }

        student.addCourse(course); // Add course to student's list
        studentRepository.save(student); // Saving updated student
        return "Student enrolled in the course successfully!";
    }
}
