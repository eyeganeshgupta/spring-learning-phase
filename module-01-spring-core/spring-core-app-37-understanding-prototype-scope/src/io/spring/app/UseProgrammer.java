package io.spring.app;

import io.spring.beans.Programmer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseProgrammer {
    public static void main(String[] args) {
        // 📌 NOTE: ApplicationContext performs Eager initialization, but for beans with scope value singleton and not prototype.
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👇🏼 Fetching Programmer Object from the Spring Container
        Programmer programmerObj01 = container.getBean("programmerObj", Programmer.class);
        Programmer programmerObj02 = container.getBean("programmerObj", Programmer.class);

        // 📇 Printing out the details of the retrieved programmerObj01 and programmerObj02
        programmerObj01.displayDetails();
        programmerObj02.displayDetails();

        System.out.println("\nAre programmerObj01 and programmerObj02 same? " + (programmerObj01 == programmerObj02));
        System.out.println("programmerObj01's hashcode: " + programmerObj01.hashCode());
        System.out.println("programmerObj02's hashcode: " + programmerObj02.hashCode());
    }
}
