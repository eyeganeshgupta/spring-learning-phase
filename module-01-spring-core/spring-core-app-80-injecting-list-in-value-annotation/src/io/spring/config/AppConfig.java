package io.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "io.spring.beans")
@PropertySource("classpath:/io/spring/resources/actor.properties")
public class AppConfig {

}
