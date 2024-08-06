package io.spring.app;

import io.spring.beans.Programmer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseProgrammer {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/computer.xml", "/io/spring/resources/programmer.xml");

        // 👇🏼 Fetching Programmer Object from the Spring Container
        Programmer programmerObj01 = container.getBean("programmerObj01", Programmer.class);
        Programmer programmerObj02 = container.getBean("programmerObj02", Programmer.class);

        // 📇 Printing out the details of the retrieved programmerObj01 and programmerObj02
        programmerObj01.displayDetails();
        programmerObj02.displayDetails();
    }
}