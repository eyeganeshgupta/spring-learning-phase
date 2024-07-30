package io.spring.app;

import io.spring.beans.UserPreferences;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseUserPreferences {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👇🏼 Fetching Math Object from the Spring Container
        UserPreferences userPrefs = container.getBean("userPrefs", UserPreferences.class);
        userPrefs.displayDetails();
    }
}
