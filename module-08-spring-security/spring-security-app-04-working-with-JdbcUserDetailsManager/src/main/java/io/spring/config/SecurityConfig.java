package io.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Configuring SecurityFilterChain...");
        http
                .authorizeHttpRequests(auth -> {
                    logger.info("Setting up public and authenticated routes.");
                    auth.requestMatchers("/api/public/**").permitAll()
                            .anyRequest().authenticated();
                })
                .httpBasic(withDefaults());
        logger.info("SecurityFilterChain configured successfully.");
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        logger.info("Creating JdbcUserDetailsManager with provided DataSource.");
        return new JdbcUserDetailsManager(dataSource);
    }

    /*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoOpPasswordEncoder.getInstance();
    }
     */
}
