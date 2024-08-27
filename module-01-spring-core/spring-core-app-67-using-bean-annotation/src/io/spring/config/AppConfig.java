package io.spring.config;

import io.spring.beans.Company;
import io.spring.beans.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    📌 Using @Bean Annotation
        👉 The @Bean annotation is a method level annotation.
        👉 When we apply this on a method then it indicates that the method produces a bean to be managed by the Spring container.
        👉 It is typically used in classes annotated with @Configuration, but it can also be used in other contexts.
*/

@Configuration
public class AppConfig {
    @Bean // @Bean tells Spring to manage Bean object of class Company.
    public Company company() {
        return new Company();
    }

    @Bean
    public Employee employee() {
        return new Employee();
    }
}
