package io.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"io.spring.invertebrate", "io.spring.vertebrate"})
public class AppConfig {

}