package io.spring.config;

import io.spring.beans.DevelopmentEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.spring.beans")
public class AppConfig {
    @Bean
    public DevelopmentEnvironment developmentEnvironment() {
        return new DevelopmentEnvironment();
    }
}
