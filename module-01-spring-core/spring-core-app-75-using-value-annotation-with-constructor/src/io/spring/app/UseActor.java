package io.spring.app;

import io.spring.beans.Actor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseActor {
    public static void main(String[] args) {
        System.out.println();
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);
        Actor actor = (Actor) container.getBean("actor");
        actor.displayDetails();
    }
}
