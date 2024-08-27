package io.spring.config;

import io.spring.invertebrate.Centipede;
import io.spring.vertebrate.Snake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    💡 Changing Bean Name
        👉 By default, the bean name is the same as the method name.
        👉 But we can change it by specifying the bean name in the name attribute of @Bean annotation.
*/

@Configuration
public class AppConfig {
    @Bean(name = "indianCobra")
    public Snake snake() {
        return new Snake();
    }

    @Bean(name = "scolopendra")
    public Centipede centipede() {
        return new Centipede();
    }
}
