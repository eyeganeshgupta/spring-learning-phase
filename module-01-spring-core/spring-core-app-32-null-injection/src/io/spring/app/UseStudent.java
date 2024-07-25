package io.spring.app;

import io.spring.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseStudent {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        Student studentObj01 = container.getBean("studentObj01", Student.class);
        Student studentObj02 = container.getBean("studentObj02", Student.class);

        // 📇 Printing out the details of the retrieved studentObj
        studentObj01.displayDetails();
        studentObj02.displayDetails();
    }
}
