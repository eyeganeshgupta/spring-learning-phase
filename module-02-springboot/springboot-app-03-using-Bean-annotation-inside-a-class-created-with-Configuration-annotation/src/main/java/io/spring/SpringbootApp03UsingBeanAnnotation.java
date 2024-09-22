package io.spring;

import io.spring.beans.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApp03UsingBeanAnnotation {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApp03UsingBeanAnnotation.class, args);
        User user = context.getBean(User.class);
        user.displayUserDetails();
    }
}
