package io.spring.mapper;

import io.spring.dto.StudentDTO;
import io.spring.dto.CourseDTO;
import io.spring.entity.Student;
import io.spring.entity.Course;

import java.util.stream.Collectors;

public class StudentMapper {
    // Converting Student entity to StudentDTO
    public static StudentDTO toStudentDTO(Student student) {
        if (student == null) {
            return null;
        }

        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setDateOfBirth(student.getDateOfBirth());
        dto.setEnrollmentDate(student.getEnrollmentDate());
        dto.setIsActive(student.getIsActive());

        // Map courses to CourseDTO
        dto.setCourses(
                student.getCourses().stream()
                        .map(CourseMapper::toCourseDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    // Converting StudentDTO to Student entity
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

        // Map CourseDTOs to Course entities (optional, only if needed)
        if (studentDTO.getCourses() != null) {
            student.setCourses(
                    studentDTO.getCourses().stream()
                            .map(CourseMapper::toCourseEntity)
                            .collect(Collectors.toSet())
            );
        }

        return student;
    }
}
