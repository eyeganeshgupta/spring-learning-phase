package io.spring;

import io.spring.model.Student;
import io.spring.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringJdbcApp02Application {
    public static void inputStudentData(Student student, Scanner scanner) {
        System.out.println("Please enter the following student details:");

        System.out.print("Student ID: ");
        student.setStudentId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("First Name: ");
        student.setFirstName(scanner.nextLine());

        System.out.print("Last Name: ");
        student.setLastName(scanner.nextLine());

        System.out.print("Email: ");
        student.setEmail(scanner.nextLine());

        System.out.print("Gender: ");
        student.setGender(scanner.nextLine());

        System.out.print("GPA: ");
        student.setGpa(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Credits Earned: ");
        student.setCreditsEarned(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Address: ");
        student.setAddress(scanner.nextLine());

        System.out.print("City: ");
        student.setCity(scanner.nextLine());

        System.out.print("State: ");
        student.setState(scanner.nextLine());

        System.out.print("Zip Code: ");
        student.setZipCode(scanner.nextLine());

        System.out.print("Country: ");
        student.setCountry(scanner.nextLine());

        System.out.print("Phone Number: ");
        student.setPhoneNumber(scanner.nextLine());

        System.out.print("Emergency Contact Phone: ");
        student.setEmergencyContactPhone(scanner.nextLine());

        System.out.println("Student data input completed successfully.");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcApp02Application.class, args);
        StudentService studentService = context.getBean(StudentService.class);

        String choice;
        Scanner scanner = new Scanner(System.in);

        do {
            Student student = context.getBean(Student.class);
            inputStudentData(student, scanner);
            studentService.addStudent(student);
            System.out.print("Would you like to add another student? (yes/no): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("yes"));


        System.out.println("Total records saved: " + studentService.getCount());

        System.out.print("Enter the Student ID to search: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        String name = studentService.findById(studentId);
        if (name != null) {
            System.out.println("Student found: " + name);
        } else {
            System.out.println("No student found with the given ID.");
        }

        scanner.close();
        System.out.println("Application terminated. Thank you for using the Student Management System.");
    }
}
