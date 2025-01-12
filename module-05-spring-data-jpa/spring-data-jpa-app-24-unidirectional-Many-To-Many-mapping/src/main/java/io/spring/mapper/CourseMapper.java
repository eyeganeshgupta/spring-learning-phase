package io.spring.mapper;

import io.spring.dto.CourseDTO;
import io.spring.entity.Course;

public class CourseMapper {
    // Converting Course entity to CourseDTO
    public static CourseDTO toCourseDTO(Course course) {
        if (course == null) {
            return null;
        }

        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setCourseCode(course.getCourseCode());
        dto.setStartDate(course.getStartDate());
        dto.setIsActive(course.getIsActive());

        return dto;
    }

    // Converting CourseDTO to Course entity
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

        return course;
    }
}
