package io.spring.config;

import io.spring.beans.Human;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
    ⭐ Using @Scope with @Bean
        👉 We can use the @Scope annotation along with @Bean annotation also for setting scope of beans configured using Java approach.
        👉 The ways of assigning values will also be same i.e., either we can use String literals or we can use ConfigurableBeanFactory interface.
*/

@Configuration
public class AppConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Human human() {
        return new Human();
    }
}
