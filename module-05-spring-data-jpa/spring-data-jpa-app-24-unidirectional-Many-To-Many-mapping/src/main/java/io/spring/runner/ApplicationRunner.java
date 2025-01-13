package io.spring.runner;

import io.spring.dto.CourseDTO;
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
        CourseDTO javaSE = new CourseDTO();
        javaSE.setName("Java SE");
        javaSE.setCourseCode("JavaSE103");
        javaSE.setIsActive(true);
        javaSE = service.addCourse(javaSE);

        CourseDTO mernStack = new CourseDTO();
        mernStack.setName("MERN Stack Web Development");
        mernStack.setCourseCode("MERNSTACK103");
        mernStack.setIsActive(true);
        mernStack = service.addCourse(mernStack);

        System.out.println("\n✅ Added Courses!");


        // Add a new student
        StudentDTO ganesh = new StudentDTO();
        ganesh.setFirstName("Ganesh");
        ganesh.setLastName("Gupta");
        ganesh.setEmail("eyeganeshgupta@gmail.com");
        ganesh.setPhoneNumber("8983971752");
        ganesh.setIsActive(true);
        ganesh = service.addStudent(ganesh);

        StudentDTO virat = new StudentDTO();
        virat.setFirstName("Virat");
        virat.setLastName("Gupta");
        virat.setEmail("virat.gupta@outlook.com");
        virat.setPhoneNumber("8898234049");
        virat.setIsActive(true);
        virat = service.addStudent(virat);

        System.out.println("\n✅ Added Students!");

        // Enroll a student in a course
        System.out.println(service.enrollStudentInCourse(ganesh.getId(), javaSE.getId()));
        System.out.println(service.enrollStudentInCourse(virat.getId(), mernStack.getId()));

        System.out.println("\n✅ Enrolled Students in Courses!");
    }
}
