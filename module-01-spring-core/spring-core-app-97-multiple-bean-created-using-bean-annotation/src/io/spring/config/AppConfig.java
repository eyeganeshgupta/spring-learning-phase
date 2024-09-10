package io.spring.config;

import io.spring.beans.DevelopmentEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.spring.beans")
public class AppConfig {
    // 🎯 Since we now have 2 beans, all type DevelopmentEnvironment, so it will create ambiguity and Spring will throw ‘NoUniqueBeanDefinitionException’.

    @Bean
    public DevelopmentEnvironment developmentEnvironment01() {
        return new DevelopmentEnvironment("Ubuntu", "IntelliJ", "GIT", "Maven", "MySQL", "JUnit", "AWS", "SonarQube", "Log4j", "Vagrant");
    }

    @Bean
    public DevelopmentEnvironment developmentEnvironment02() {
        return new DevelopmentEnvironment("Windows 11", "Eclipse", "SVN", "Gradle", "PostgreSQL", "Selenium", "Heroku", "Checkstyle", "SLF4J", "VirtualBox");
    }
}
