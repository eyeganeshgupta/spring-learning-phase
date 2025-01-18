package io.spring.runner;

import io.spring.dto.CourseDTO;
import io.spring.dto.StudentDTO;
import io.spring.service.CourseService;
import io.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppRunner implements CommandLineRunner {
    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public AppRunner(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a new Course
        CourseDTO springBoot = new CourseDTO();
        springBoot.setName("Spring Boot");
        springBoot.setCourseCode("SB101");
        springBoot.setStartDate(LocalDate.of(2025, 1, 17));
        springBoot.setIsActive(true);

        CourseDTO savedSpringBoot = courseService.createCourse(springBoot);

        // Create a new Student
        StudentDTO ganesh = new StudentDTO();
        ganesh.setFirstName("Ganesh");
        ganesh.setLastName("Gupta");
        ganesh.setEmail("eyeganeshgupta@gmail.com");

        StudentDTO savedGanesh = studentService.createStudent(ganesh);

        // Enroll Ganesh Gupta in Spring Boot Basics (Managed by owning side: Student)
        studentService.enrollInCourse(savedGanesh.getId(), savedSpringBoot.getId());

        // Print enrolled students for Spring Boot Basics (from Course perspective)
        System.out.println("Enrolled Students in Spring Boot Basics:");

        System.out.println(courseService.getCourseById(savedSpringBoot.getId()));

        // Remove Ganesh Gupta from Spring Boot Basics (Managed by owning side: Student)
        studentService.removeFromCourse(savedGanesh.getId(), savedSpringBoot.getId());

        System.out.println("Updated Students in Spring Boot Basics:");
        System.out.println(courseService.getCourseById(savedSpringBoot.getId()));
    }
}
