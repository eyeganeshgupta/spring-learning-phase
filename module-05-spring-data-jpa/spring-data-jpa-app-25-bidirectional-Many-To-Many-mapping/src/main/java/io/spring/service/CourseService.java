package io.spring.service;

import io.spring.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(Long id, CourseDTO courseDTO);
    void deleteCourse(Long id);
    CourseDTO getCourseById(Long id);
    List<CourseDTO> getAllCourses();
}
