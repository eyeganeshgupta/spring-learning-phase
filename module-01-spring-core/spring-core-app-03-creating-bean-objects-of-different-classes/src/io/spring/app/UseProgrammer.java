package io.spring.app;

import io.spring.beans.Programmer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseProgrammer {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/beanconf.xml");

        // 📌 NOTE: ApplicationContext performs Eager initialization, but for beans with scope value singleton and not prototype.
        System.out.println("Container Started");

        // 👇🏼 Fetching Programmer Object from the Spring Container
        // Using .getBean(String) method
        Programmer programmerObj = (Programmer) container.getBean("programmerObj");

        // 📇 Printing out the details of the retrieved Programmer object
        System.out.println("\nProgrammer Name: " + programmerObj.getName());
        System.out.println("Programmer Age: " + programmerObj.getAge());
        System.out.println("Programming Language: " + programmerObj.getLanguage());
        System.out.println("Laptop Brand: " + programmerObj.getLaptop().getBrand());
        System.out.println("Laptop Model: " + programmerObj.getLaptop().getModel());
        System.out.println("Laptop RAM Size: " + programmerObj.getLaptop().getRamSize());
        System.out.println("Laptop Storage Size: " + programmerObj.getLaptop().getStorageSize());
    }
}
