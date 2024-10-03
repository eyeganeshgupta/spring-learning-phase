package io.spring;

import io.spring.model.Student;
import io.spring.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringJdbcApp01WorkingWithH2DatabaseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcApp01WorkingWithH2DatabaseApplication.class, args);
        Student student = context.getBean(Student.class);
        StudentService studentService = context.getBean(StudentService.class);

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter student information:");

        System.out.print("Student ID: ");
        student.setStudentId(scn.nextInt());
        scn.nextLine();

        System.out.print("First Name: ");
        student.setFirstName(scn.nextLine());

        System.out.print("Last Name: ");
        student.setLastName(scn.nextLine());

        System.out.print("Email: ");
        student.setEmail(scn.nextLine());

        System.out.print("Gender: ");
        student.setGender(scn.nextLine());

        System.out.print("GPA: ");
        student.setGpa(scn.nextDouble());
        scn.nextLine();

        System.out.print("Credits Earned: ");
        student.setCreditsEarned(scn.nextInt());
        scn.nextLine();

        System.out.print("Address: ");
        student.setAddress(scn.nextLine());

        System.out.print("City: ");
        student.setCity(scn.nextLine());

        System.out.print("State: ");
        student.setState(scn.nextLine());

        System.out.print("Zip Code: ");
        student.setZipCode(scn.nextLine());

        System.out.print("Country: ");
        student.setCountry(scn.nextLine());

        System.out.print("Phone Number: ");
        student.setPhoneNumber(scn.nextLine());

        System.out.print("Emergency Contact Phone: ");
        student.setEmergencyContactPhone(scn.nextLine());

        studentService.addStudent(student);

        System.out.println(student.toString());

        scn.close();
    }
}
