package io.spring;

import io.spring.beans.User;
import io.spring.services.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApp02Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApp02Application.class, args);

        // Get the User bean
        User user = context.getBean(User.class);
        user.displayUserDetails();

        // Get the EmailService bean
        EmailService emailService = context.getBean(EmailService.class);
    }
}
