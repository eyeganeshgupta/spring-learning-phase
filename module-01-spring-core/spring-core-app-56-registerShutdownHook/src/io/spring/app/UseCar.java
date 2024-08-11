package io.spring.app;

import io.spring.beans.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCar {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");
        Car carObj = container.getBean("carObj", Car.class);
        carObj.drive();
        carObj.turnOnHeadlights();
        carObj.playMusic("Neele Neele Ambar Par");

        /*
        ❓ Why Spring does not execute stop() method?
            👉 Because it was configured to be called when the bean gets destroyed.
            👉 And in Spring if the bean is singleton it gets destroyed when the container stops, but since we didn't stop the container so this method was not called.
        */

        /*
        ❓ How to close or shutdown the Spring container?
            👉 Closing or shutting down a Spring container can be done in several ways, depending on the type of application and how the Spring container is managed.
            👉 But the two most common methods are:
                1️⃣ close()
                2️⃣ registerShutdownHook()
        */

        /*
        💡 Using registerShutdownHook() method
            👉 The registerShutdownHook() method also belongs to the class AbstractApplicationContext.
            👉 It registers a shutdown hook with the JVM runtime, ensuring that the Spring container is properly closed when the JVM shuts down normally.
        */

        // No need to explicitly close the context, as the shutdown hook will
        container.registerShutdownHook();

        System.out.println("Bye");
    }
}
