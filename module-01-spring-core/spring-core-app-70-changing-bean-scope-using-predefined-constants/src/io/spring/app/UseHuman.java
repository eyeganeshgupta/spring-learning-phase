package io.spring.app;

import io.spring.beans.Human;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseHuman {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);

        Human human01 = (Human) container.getBean("human");
        Human human02 = (Human) container.getBean("human");

        System.out.println("Human01 Hashcode: " + human01.hashCode());
        System.out.println("Human02 Hashcode: " + human02.hashCode());
    }
}
