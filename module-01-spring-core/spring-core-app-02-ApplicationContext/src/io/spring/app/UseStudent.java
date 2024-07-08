package io.spring.app;

import io.spring.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseStudent {
    public static void main(String[] args) {
        /*
        Resource resourceFile = new ClassPathResource("/io/spring/resources/beanconf.xml");
        BeanFactory container = new XmlBeanFactory(resourceFile);
        */

        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/beanconf.xml");

        // 📌 NOTE: ApplicationContext performs Eager initialization, but for beans with scope value singleton and not prototype.
        System.out.println("Container Started");

        // 👇🏼 Fetching Student Object from the Spring Container

        /*
        Version 1: Using .getBean(String) method
        This method requires providing the bean name as a string argument and explicit type casting.
        Student studentObj = (Student) container.getBean("studentObj");
        */

        // Version 2: Using .getBean(Class<T>) method
        // This method requires the class type as an argument and eliminates the need for explicit type casting.
        Student studentObj = container.getBean(Student.class);

        // Printing out the details of the retrieved Student object
        System.out.println("Student name: " + studentObj.getName());
        System.out.println("Student Roll no: " + studentObj.getRollNo());
    }
}
