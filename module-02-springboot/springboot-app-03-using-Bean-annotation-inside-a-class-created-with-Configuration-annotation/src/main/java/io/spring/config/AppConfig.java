package io.spring.config;

import io.spring.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public User user() {
        return new User("Ganesh", "Gupta", "eyeguptaganesh", "eyeguptaganesh@gmail.com", "+91 89839 71752", "Mumbai, India", 21, "Male", "lockandkey".toCharArray(), true);
    }
}
