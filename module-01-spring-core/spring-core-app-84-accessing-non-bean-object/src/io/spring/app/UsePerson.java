package io.spring.app;

import io.spring.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UsePerson {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);

        Person person = (Person) container.getBean("person");

        System.out.println("\nName: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Date of Birth: " + person.getFormattedDateOfBirth("dd-MM-yyyy"));
        System.out.println("Age: " + person.calculateAge());
    }
}
