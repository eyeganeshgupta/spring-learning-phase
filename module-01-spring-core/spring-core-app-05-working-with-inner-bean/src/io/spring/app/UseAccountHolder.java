package io.spring.app;

import io.spring.beans.AccountHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseAccountHolder {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/beanconf.xml");

        // 👇🏼 Fetching AccountHolder Object from the Spring Container
        // Using .getBean(String, Class) method
        AccountHolder accountHolderObj01 = container.getBean("accountHolderObj01", AccountHolder.class);
        AccountHolder accountHolderObj02 = container.getBean("accountHolderObj02", AccountHolder.class);

        // 📇 Printing out the details of the retrieved accountHolderObj01
        System.out.println("\nAccount Holder Name: " + accountHolderObj01.getName());
        System.out.println("Account no.: " + accountHolderObj01.getAccount().getAccountNumber());
        System.out.println("Balance: " + accountHolderObj01.getAccount().getBalance());
        System.out.println("Account Type: " + accountHolderObj01.getAccount().getAccountType());
        System.out.println("Address: " + accountHolderObj01.getAddress());
        System.out.println("Email: " + accountHolderObj01.getEmail());
        System.out.println("Phone no.: " + accountHolderObj01.getPhoneNumber());

        System.out.println("\n============================");

        // 📇 Printing out the details of the retrieved accountHolderObj02
        System.out.println("\nAccount Holder Name: " + accountHolderObj02.getName());
        System.out.println("Account no.: " + accountHolderObj02.getAccount().getAccountNumber());
        System.out.println("Balance: " + accountHolderObj02.getAccount().getBalance());
        System.out.println("Account Type: " + accountHolderObj02.getAccount().getAccountType());
        System.out.println("Address: " + accountHolderObj02.getAddress());
        System.out.println("Email: " + accountHolderObj02.getEmail());
        System.out.println("Phone no.: " + accountHolderObj02.getPhoneNumber());
    }
}
