package io.spring.app;

import io.spring.beans.Country;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseCountry {
    public static void main(String[] args) {
        System.out.println("\n‘AnnotationConfigApplicationContext’ is a powerful tool in Spring for configuring and bootstrapping applications using Java annotations and classes instead of XML, offering a modern and flexible way to manage the application context.");

        // 👉 Create the Spring container
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext();

        // 👉 Register the Country bean with the container
        System.out.println("\nHow to register the bean?");
        System.out.println("    To register the component class with the Spring container we need to call the method register().");
        System.out.println("    This method belongs to the class AnnotationConfigApplicationContext.");
        System.out.println("    By registering the component classes, we tell the Spring container which classes to use for creating beans, managing dependencies, and setting up the application environment.");
        container.register(io.spring.beans.Country.class);

        // 👉 Refresh the container to apply the configuration
        System.out.println("\nHow to refresh the container?");
        System.out.println("    Calling the register() method only tells Spring that these classes have to be managed by the container.");
        System.out.println("    It does not initializes the container.");
        System.out.println("    In order to do that we have to call the method refresh().\n");
        container.refresh();

        // 👉 Retrieve the Country bean from the container
        // NOTE: Once we refresh the container then only country bean will be created.
        Country country = (Country) container.getBean("country");

        // 👉 Use the Country bean
        country.displayDetails();
    }
}
