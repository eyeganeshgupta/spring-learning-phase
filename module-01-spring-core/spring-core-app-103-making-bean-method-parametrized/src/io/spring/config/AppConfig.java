package io.spring.config;

import io.spring.beans.DevelopmentEnvironment;
import io.spring.beans.Programmer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
⭐ Making the @Bean method parametrized
---------------------
    👉 Instead of calling the ‘developmentEnvironment()’ method manually, we can also make the ‘programmer()’ method parametrized and accept ‘DevelopmentEnvironment’ bean as argument.
    👉 In this scenario, the Spring container will automatically pass the dependent ‘DevelopmentEnvironment’ bean as argument to the ‘programmer()’ method.
    👉 Then we can use it for performing DI in Programmer bean.
*/

@Configuration
@ComponentScan(basePackages = "io.spring.beans")
public class AppConfig {
    @Bean
    public DevelopmentEnvironment developmentEnvironment() {
        return new DevelopmentEnvironment("Ubuntu", "IntelliJ", "GIT", "Maven", "MySQL", "JUnit", "AWS", "SonarQube", "Log4j", "Vagrant");
    }

    @Bean
    // 📢 The Spring container will automatically pass this argument.
    public Programmer programmer(DevelopmentEnvironment ubuntu) {
        return new Programmer(ubuntu);
    }
}
