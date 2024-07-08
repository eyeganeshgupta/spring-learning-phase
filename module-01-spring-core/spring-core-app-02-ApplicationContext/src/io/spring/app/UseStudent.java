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
        // Using .getBean(String) method
        Student studentObj01 = (Student) container.getBean("studentObj01");
        Student studentObj02 = (Student) container.getBean("studentObj02");

        // 📇 Printing out the details of the retrieved Student object
        System.out.println("\nStudent name: " + studentObj01.getName());
        System.out.println("Student Roll no: " + studentObj01.getRollNo());

        System.out.println("=============================");

        System.out.println("Student name: " + studentObj02.getName());
        System.out.println("Student Roll no: " + studentObj02.getRollNo());
    }
}
