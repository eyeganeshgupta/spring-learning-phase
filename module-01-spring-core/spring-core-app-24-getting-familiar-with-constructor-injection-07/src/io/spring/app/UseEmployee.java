package io.spring.app;

import io.spring.beans.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseEmployee {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");
        // 👇🏼 Fetching Employee Object from the Spring Container
        Employee employeeObj = container.getBean("employeeObj", Employee.class);
        employeeObj.displayInfo();
    }
}
