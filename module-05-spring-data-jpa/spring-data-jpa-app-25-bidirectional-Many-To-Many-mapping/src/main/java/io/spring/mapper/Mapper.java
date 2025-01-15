package io.spring.mapper;

import io.spring.dto.CourseDTO;
import io.spring.dto.StudentDTO;
import io.spring.entity.Course;
import io.spring.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static CourseDTO toCourseDTO(Course course) {
        if (course == null) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setStartDate(course.getStartDate());
        courseDTO.setIsActive(course.getIsActive());

        if (course.getStudents() != null) {
            List<StudentDTO> studentDTOs = course.getStudents().stream()
                    .map(Mapper::toStudentDTO)
                    .collect(Collectors.toList());
            courseDTO.setEnrolledStudents(studentDTOs);
        }

        return courseDTO;
    }

    public static Course toCourseEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }

        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setStartDate(courseDTO.getStartDate());
        course.setIsActive(courseDTO.getIsActive());

        if (courseDTO.getEnrolledStudents() != null) {
            course.setStudents(courseDTO.getEnrolledStudents().stream()
                    .map(Mapper::toStudentEntity)
                    .collect(Collectors.toSet()));
        }

        return course;
    }

    public static StudentDTO toStudentDTO(Student student) {
        if (student == null) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPhoneNumber(student.getPhoneNumber());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setEnrollmentDate(student.getEnrollmentDate());
        studentDTO.setIsActive(student.getIsActive());

        if (student.getCourses() != null) {
            List<CourseDTO> courseDTOS = student.getCourses().stream()
                    .map(Mapper::toCourseDTO)
                    .collect(Collectors.toList());
            studentDTO.setEnrolledCourses(courseDTOS);
        }

        return studentDTO;
    }

    public static Student toStudentEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setEnrollmentDate(studentDTO.getEnrollmentDate());
        student.setIsActive(studentDTO.getIsActive());

        if (studentDTO.getEnrolledCourses() != null) {
            student.setCourses(studentDTO.getEnrolledCourses().stream()
                    .map(Mapper::toCourseEntity)
                    .collect(Collectors.toSet()));
        }

        return student;
    }
}
