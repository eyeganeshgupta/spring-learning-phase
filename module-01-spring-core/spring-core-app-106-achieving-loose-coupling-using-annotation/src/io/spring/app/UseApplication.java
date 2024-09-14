package io.spring.app;

import io.spring.beans.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseApplication {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);
        Application application = (Application) container.getBean("application");
        application.displayAppDetails();
    }
}
