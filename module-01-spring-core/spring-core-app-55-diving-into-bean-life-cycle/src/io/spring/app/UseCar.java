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
        💡 Using close() method
            👉 The close() method belongs to the class AbstractApplicationContext which is the parent class of ClassPathXmlApplicationContext.
            👉 It is used to explicitly close the Spring application context, releasing all resources and destroying all beans that are managed by the container.
        */

        // Will explicitly close the container and before removing the bean will call the destroy method.
        container.close();
    }
}
