package io.spring.app;

import io.spring.beans.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCustomer {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");
        Customer customerObj = container.getBean("customerObj", Customer.class);
        customerObj.displayDetails();

        // ⚠️ This code will throw an exception called UnsatisfiedDependencyException.
        // ⛔ This is because Spring will find 2 beans with matching type i.e., io.spring.beans.Account.
    }
}
