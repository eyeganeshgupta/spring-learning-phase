package io.spring.app;

import io.spring.beans.Actor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseActor {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);

        Actor beanNamedActor = (Actor) container.getBean("beanNamedActor");
        Actor actor02 = (Actor) container.getBean("actor02");

        beanNamedActor.displayDetails();
        actor02.displayDetails();
    }
}