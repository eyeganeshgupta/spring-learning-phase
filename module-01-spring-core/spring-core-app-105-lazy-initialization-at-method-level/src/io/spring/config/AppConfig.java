package io.spring.config;

import io.spring.beans.PanCard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/*
⭐ Lazy Initialization
---------------------
    👉 By default, Spring performs eager initialization of Singleton bean when the application context is loaded.
    👉 However, by enabling lazy initialization, a bean can be created only when it's requested.
    👉 To achieve lazy initialization in Spring, we can use the @Lazy annotation.
    👉 This can be applied at both the ‘class level’ and the ‘method level’ (for @Bean methods).
*/

/*
⭐ Using @Lazy at Class Level
-------------------------------
    1️⃣ When we annotate a component with @Lazy, then Spring will delay the creation of that bean until it is first requested.
    2️⃣ The term requested means ‘injected’ or ‘accessed’.
*/

/*
⭐ Using @Lazy at Method Level
-------------------------------
    1️⃣ We can also make specific beans defined in a @Configuration class lazy by applying @Lazy on the method.
*/

@Configuration
@ComponentScan(basePackages = "io.spring.beans")
public class AppConfig {
    @Bean
    @Lazy
    public PanCard panCard() {
        return new PanCard();
    }
}
