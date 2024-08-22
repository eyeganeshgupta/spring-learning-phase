package io.spring.app;

import io.spring.beans.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCar {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        container.registerShutdownHook();

        Car carObj = container.getBean("carObj", Car.class);
        carObj.drive();
        carObj.turnOnHeadlights();
        carObj.playMusic("Neele Neele Ambar Par");
    }
}
