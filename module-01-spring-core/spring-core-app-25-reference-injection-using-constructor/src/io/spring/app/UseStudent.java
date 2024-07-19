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
        System.out.println("Email: " + studentObj.getEmail());
        System.out.println("Address Details: ");
        System.out.println("House Number: " + studentObj.getAddress().getHouseNumber());
        System.out.println("Landmark: " + studentObj.getAddress().getLandmark());
        System.out.println("Street: " + studentObj.getAddress().getStreet());
        System.out.println("City: " + studentObj.getAddress().getCity());
        System.out.println("State: " + studentObj.getAddress().getState());
        System.out.println("Country: " + studentObj.getAddress().getCountry());
        System.out.println("Zipcode: " + studentObj.getAddress().getZipCode());
    }
}
