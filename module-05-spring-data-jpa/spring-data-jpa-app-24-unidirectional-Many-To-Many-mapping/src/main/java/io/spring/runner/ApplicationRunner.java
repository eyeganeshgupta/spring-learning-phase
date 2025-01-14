package io.spring.runner;

import io.spring.dto.CourseDTO;
import io.spring.dto.StudentDTO;
import io.spring.service.StudentCourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        javaSE.setCourseCode("JavaSE101");
        javaSE.setStartDate(LocalDate.of(2025, 1, 1));
        javaSE.setIsActive(true);
        javaSE = service.addCourse(javaSE);

        CourseDTO mernStack = new CourseDTO();
        mernStack.setName("MERN Stack Web Development");
        mernStack.setCourseCode("MERNSTACK");
        mernStack.setStartDate(LocalDate.of(2025, 1, 15));
        mernStack.setIsActive(true);
        mernStack = service.addCourse(mernStack);

        System.out.println("\n✅ Added Courses!");


        // Add a new student
        StudentDTO ganesh = new StudentDTO();
        ganesh.setFirstName("Ganesh");
        ganesh.setLastName("Gupta");
        ganesh.setEmail("eyeganeshgupta@gmail.com");
        ganesh.setPhoneNumber("8983971752");
        ganesh.setDateOfBirth(LocalDate.of(2003, 2, 18));
        ganesh.setEnrollmentDate(LocalDate.of(2025, 1, 1));
        ganesh.setIsActive(true);
        ganesh = service.addStudent(ganesh);

        StudentDTO virat = new StudentDTO();
        virat.setFirstName("Virat");
        virat.setLastName("Gupta");
        virat.setEmail("virat.gupta@outlook.com");
        virat.setPhoneNumber("8898234049");
        virat.setDateOfBirth(LocalDate.of(2007, 7, 16));
        virat.setEnrollmentDate(LocalDate.of(2025, 1, 6));
        virat.setIsActive(true);
        virat = service.addStudent(virat);

        System.out.println("\n✅ Added Students!");


        // Enroll students in courses
        System.out.println(service.enrollStudentInCourse(ganesh.getId(), javaSE.getId()));
        System.out.println(service.enrollStudentInCourse(virat.getId(), mernStack.getId()));
        System.out.println("\n✅ Enrolled Students in Courses!");


        // Retrieve all students along with their courses
        System.out.println("\n🎓 All Students and Their Courses:");
        var students=service.getAllStudentsWithCourses();
        students.forEach(System.out::println);

        // Delete a student
        System.out.println(service.deleteStudent(ganesh.getId()));
        System.out.println("\n✅ Deleted " + ganesh.getFirstName() + "!");
    }
}
