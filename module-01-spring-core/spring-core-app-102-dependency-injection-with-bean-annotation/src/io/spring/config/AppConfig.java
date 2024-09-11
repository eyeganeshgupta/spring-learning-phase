package io.spring.config;

import io.spring.beans.DevelopmentEnvironment;
import io.spring.beans.Programmer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
⭐ Performing Dependency Injection with @Bean
---------------------
    👉 As mentioned previously that if instead of @Component we are creating the target bean using @Bean then Spring will not perform dependency injection automatically.
    👉 Rather we as a programmer will have to pass the dependent object into the target object either through its constructor or setter method.
*/

@Configuration
@ComponentScan(basePackages = "io.spring.beans")
public class AppConfig {
    @Bean
    public DevelopmentEnvironment developmentEnvironment() {
        return new DevelopmentEnvironment("Ubuntu", "IntelliJ", "GIT", "Maven", "MySQL", "JUnit", "AWS", "SonarQube", "Log4j", "Vagrant");
    }

    @Bean
    public Programmer programmer() {
        return new Programmer(developmentEnvironment());
    }
}
