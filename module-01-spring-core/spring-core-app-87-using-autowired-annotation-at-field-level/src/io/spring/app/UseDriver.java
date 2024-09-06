package io.spring.app;

import io.spring.beans.Driver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseDriver {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);
        Driver driver = (Driver) container.getBean("driver");
        driver.displayDriverDetails();
    }
}
