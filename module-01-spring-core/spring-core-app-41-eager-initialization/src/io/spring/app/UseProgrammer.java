package io.spring.app;

import io.spring.beans.Programmer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseProgrammer {
    public static void main(String[] args) {
        // 📌 NOTE: ApplicationContext performs Eager initialization, but for beans with scope value singleton and not prototype.
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👇🏼 Fetching Programmer Object from the Spring Container
        Programmer programmerObj = container.getBean("programmerObj", Programmer.class);

        // 📇 Printing out the details of the retrieved programmerObj
        programmerObj.displayDetails();
    }
}
