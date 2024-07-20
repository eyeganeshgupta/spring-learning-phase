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
        System.out.println("Student Details: \n" + studentObj.toString());
    }
}
