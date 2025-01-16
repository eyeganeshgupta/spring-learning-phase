package io.spring.repository;

import io.spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByIsActive(Boolean isActive);

    List<Student> findByFirstNameContainingIgnoreCase(String keyword);

    Student findByEmail(String email);

    List<Student> findByCourses_Id(Long courseId);
}
