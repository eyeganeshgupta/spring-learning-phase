package io.spring.app;

import io.spring.beans.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseCircle {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);
        Circle circleObj = (Circle) container.getBean("circle");
        circleObj.displayDetails();
    }
}