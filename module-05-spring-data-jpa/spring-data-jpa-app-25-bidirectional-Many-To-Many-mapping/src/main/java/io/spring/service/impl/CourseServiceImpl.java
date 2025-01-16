package io.spring.service.impl;

import io.spring.dto.CourseDTO;
import io.spring.entity.Course;
import io.spring.mapper.Mapper;
import io.spring.repository.CourseRepository;
import io.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = Mapper.toCourseEntity(courseDTO);
        return Mapper.toCourseDTO(courseRepository.save(course));
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        existingCourse.setName(courseDTO.getName());
        existingCourse.setCourseCode(courseDTO.getCourseCode());
        existingCourse.setStartDate(courseDTO.getStartDate());
        existingCourse.setIsActive(courseDTO.getIsActive());
        return Mapper.toCourseDTO(courseRepository.save(existingCourse));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(Mapper::toCourseDTO)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(Mapper::toCourseDTO)
                .collect(Collectors.toList());
    }

    // NOTE:: Enrollment and removal are handled by StudentService since Student is the owning side.
}
