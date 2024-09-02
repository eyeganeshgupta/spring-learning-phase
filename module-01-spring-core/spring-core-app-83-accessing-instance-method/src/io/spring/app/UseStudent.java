package io.spring.app;

import io.spring.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseStudent {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);
        Student student = (Student) container.getBean("student");
        student.displayDetails();
    }
}
