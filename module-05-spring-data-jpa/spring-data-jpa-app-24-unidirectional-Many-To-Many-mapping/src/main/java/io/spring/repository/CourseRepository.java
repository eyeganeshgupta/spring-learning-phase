package io.spring.repository;

import io.spring.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE from student_course sc where sc.course_id = ?1", nativeQuery = true)
    public void deleteCourseStudents(Long courseId);
}
