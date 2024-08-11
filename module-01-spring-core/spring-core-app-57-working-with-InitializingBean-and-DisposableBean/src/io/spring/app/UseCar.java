package io.spring.app;

import io.spring.beans.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
💡 Using Spring Interfaces
------------------------
    1️⃣ To programmatically handle the lifecycle methods of bean, Spring provides us two interfaces
    2️⃣ These are by the name InitializingBean and DisposableBean.
    3️⃣ Both of them are available in the package
        org.springframework.beans.factory
    4️⃣ They have the methods afterPropertiesSet() and destroy() declared in them which we can override in our bean class.
    5️⃣ The container will invoke the afterPropertiesSet() method as it starts and the bean is instantiated whereas, the destroy() method is invoked as soon as the container is closed.
*/

public class UseCar {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        container.registerShutdownHook();

        Car carObj = container.getBean("carObj", Car.class);
        carObj.drive();
        carObj.turnOnHeadlights();
        carObj.playMusic("Neele Neele Ambar Par");
    }
}
