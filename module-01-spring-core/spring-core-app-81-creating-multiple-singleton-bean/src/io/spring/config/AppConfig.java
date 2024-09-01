package io.spring.config;

import io.spring.beans.Actor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.spring.beans")
public class AppConfig {
    @Bean(name = "beanNamedActor")
    public Actor actor01() {
        return new Actor("Hrithik", "Roshan", 50, "Male", "Indian", 27);
    }

    @Bean()
    public Actor actor02() {
        return new Actor("Tom", "Cruise", 62, "Male", "American", 13);
    }
}
