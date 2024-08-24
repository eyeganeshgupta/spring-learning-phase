package io.spring.app;

import io.spring.beans.Country;
import io.spring.beans.State;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseBeans {
    public static void main(String[] args) {
        /*
            ❓ What is Component Scanning?
                ╰┈➤ Component scanning in Spring is a mechanism used to automatically ‘detect’ and ‘register’ beans in the Spring application context.
                ╰┈➤ It simplifies the configuration process, especially in large applications.

            ❓ How to enable Component scanning?
                ╰┈➤ Component scanning can be enabled in 2 ways:
                    1️⃣ Using XML
                    2️⃣ Using Java Configuration
        */

        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👉 Retrieve the Country and State bean from the container
        Country country = (Country) container.getBean("country");
        State state = (State) container.getBean("state");

        // 👉 Use the Country and State bean
        country.displayDetails();
        state.displayDetails();
    }
}
