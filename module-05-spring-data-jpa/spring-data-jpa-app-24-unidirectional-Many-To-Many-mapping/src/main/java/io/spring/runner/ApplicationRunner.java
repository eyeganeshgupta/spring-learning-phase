package io.spring.runner;

import io.spring.dto.StudentDTO;
import io.spring.entity.Course;
import io.spring.entity.Student;
import io.spring.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final StudentCourseService service;

    public ApplicationRunner(StudentCourseService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add a new course
        Course math = new Course();
        math.setName("Math 101");
        math.setCourseCode("MATH101");
        math.setIsActive(true);
        service.addCourse(math);

        Course science = new Course();
        science.setName("Science 102");
        science.setCourseCode("SCI102");
        science.setIsActive(true);
        service.addCourse(science);

        System.out.println("\n✅ Added Courses!");
    }
}
