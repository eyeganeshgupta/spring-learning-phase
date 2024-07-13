package io.spring.app;

import io.spring.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseStudent {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👇🏼 Fetching Student Object from the Spring Container
        // Using .getBean(String, Class) method
        Student studentObj = container.getBean("studentObj", Student.class);

        // 📇 Printing out the details of the retrieved studentObj
        System.out.println("Student id: " + studentObj.getStudentId());
        System.out.println("Name: " + studentObj.getName());
        System.out.println("Age: " + studentObj.getAge());
        System.out.println("Grade: " + studentObj.getGrade());
        System.out.println("\nSubjects: ");
        studentObj.getSubjects().forEach(subject -> System.out.println(subject));
        System.out.println("\nMarks Obtained: ");
        studentObj.getMarks().forEach(mark -> System.out.println(mark));
    }
}
