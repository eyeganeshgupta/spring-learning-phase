package io.spring.app;

import io.spring.invertebrate.Centipede;
import io.spring.vertebrate.Snake;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseBeans {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👉 Retrieve the Snake and Centipede bean from the container
        Snake indianCobra = (Snake) container.getBean("indianCobra");
        Centipede scolopendra = (Centipede) container.getBean("scolopendra");

        // 👉 Use the Snake and Centipede bean
        indianCobra.displayDetails();
        scolopendra.displayDetails();
    }
}