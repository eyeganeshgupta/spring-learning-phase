package io.spring.app;

import io.spring.beans.Programmer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseProgrammer {
    public static void main(String[] args) {
        // 📌 NOTE: ApplicationContext performs Eager initialization, but for beans with scope value singleton and not prototype.
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/beanconf.xml");

        // 👇🏼 Fetching Programmer Object from the Spring Container
        // Using .getBean(String, Class) method
        Programmer programmerObj01 = container.getBean("programmerObj01", Programmer.class);
        Programmer programmerObj02 = container.getBean("programmerObj02", Programmer.class);

        // 📇 Printing out the details of the retrieved programmerObj01
        System.out.println("\nProgrammer Name: " + programmerObj01.getName());
        System.out.println("Programmer Age: " + programmerObj01.getAge());
        System.out.println("Programming Language: " + programmerObj01.getLanguage());
        System.out.println("Computer Brand: " + programmerObj01.getComputer().getBrand());
        System.out.println("Computer Processor: " + programmerObj01.getComputer().getProcessor());
        System.out.println("Computer RAM Size: " + programmerObj01.getComputer().getRamSize());
        System.out.println("Computer Storage Size: " + programmerObj01.getComputer().getStorageSize());

        System.out.println("\n============================");

        System.out.println("\nProgrammer Name: " + programmerObj02.getName());
        System.out.println("Programmer Age: " + programmerObj02.getAge());
        System.out.println("Programming Language: " + programmerObj02.getLanguage());
        System.out.println("Computer Brand: " + programmerObj02.getComputer().getBrand());
        System.out.println("Computer Processor: " + programmerObj02.getComputer().getProcessor());
        System.out.println("Computer RAM Size: " + programmerObj02.getComputer().getRamSize());
        System.out.println("Computer Storage Size: " + programmerObj02.getComputer().getStorageSize());
    }
}
