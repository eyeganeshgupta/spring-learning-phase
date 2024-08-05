package io.spring.app;

import io.spring.beans.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCustomer {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👇🏼 Fetching Customer Object from the Spring Container
        Customer customerObj = container.getBean("customerObj", Customer.class);

        // 📇 Printing out the details of the retrieved customerObj
        customerObj.displayDetails();
    }
}
