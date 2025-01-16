package io.spring.repository;

import io.spring.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByIsActive(Boolean isActive);

    List<Course> findByNameContainingIgnoreCase(String keyword);

    Course findByCourseCode(String courseCode);
}
