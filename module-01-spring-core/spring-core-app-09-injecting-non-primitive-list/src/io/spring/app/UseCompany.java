package io.spring.app;

import io.spring.beans.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCompany {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👇🏼 Fetching Company Object from the Spring Container
        // Using .getBean(String, Class) method
        Company companyObj = container.getBean("companyObj", Company.class);

        // 📇 Printing out the details of the retrieved companyObj
        System.out.println("Company Name: " + companyObj.getCompanyName());
        System.out.println("Company Address: " + companyObj.getAddress());
        System.out.println("Company Employees: ");
        companyObj.getWorkers().forEach(worker -> System.out.println(worker));
    }
}
