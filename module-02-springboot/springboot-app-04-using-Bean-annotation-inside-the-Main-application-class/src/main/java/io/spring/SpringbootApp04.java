package io.spring;

import io.spring.beans.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApp04 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApp04.class, args);
        User user = (User) context.getBean("user");
        user.displayUserDetails();
    }

    @Bean
    public User user() {
        return new User("Ganesh", "Gupta", "eyeguptaganesh",
                "eyeguptaganesh@gmail.com", "+91 89839 71752",
                "Mumbai, India", 21, "Male", "lockandkey".toCharArray(),
                true);
    }
}
