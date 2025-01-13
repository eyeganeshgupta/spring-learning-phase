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
    public CourseDTO addCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.toCourseDTO(savedCourse);
    }

    // Add a new student
    public StudentDTO addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toStudentDTO(savedStudent);
    }
}
