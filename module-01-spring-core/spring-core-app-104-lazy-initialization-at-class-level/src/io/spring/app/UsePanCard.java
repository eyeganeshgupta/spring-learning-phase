package io.spring.app;

import io.spring.beans.PanCard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UsePanCard {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(io.spring.config.AppConfig.class);
        PanCard panCard = (PanCard) container.getBean("panCard");
        panCard.displayDetails();
    }
}
