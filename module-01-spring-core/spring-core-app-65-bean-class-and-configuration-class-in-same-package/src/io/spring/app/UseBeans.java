package io.spring.app;

import io.spring.beans.Company;
import io.spring.beans.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseBeans {
    public static void main(String[] args) {
        System.out.println();

        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.beans.AppConfig.class);
        Company company = (Company) container.getBean("company");
        Employee employee = (Employee) container.getBean("employee");

        company.displayDetails();
        employee.displayDetails();
    }
}
