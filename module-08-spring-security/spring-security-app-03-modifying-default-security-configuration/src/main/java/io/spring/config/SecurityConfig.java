package io.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        logger.info("Configuring HTTP security filter chain...");

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/accounts/**").authenticated()
                        .requestMatchers("/api/public/**",
                                "/api/info",
                                "/login",
                                "/favicon.ico",
                                "/css/**",
                                "/js/**",
                                "/error").permitAll()
                )
                // .formLogin(withDefaults())
                // .formLogin(form -> form.disable())
                // .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(withDefaults());
        // .httpBasic(AbstractHttpConfigurer::disable);

        // Deprecated way
        // http.formLogin().disable();

        logger.info("Security filter chain configured with basic HTTP authentication.");

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        logger.info("Creating in-memory user details service...");

        UserDetails userOne = User.withUsername("ganesh")
                .password("{noop}ganesh")
                .roles("USER")
                .build();

        UserDetails userTwo = User.withUsername("virat")
                .password("{noop}virat")
                .roles("ADMIN")
                .build();

        logger.info("In-memory users created: ganesh (USER) and virat (ADMIN).");

        return new InMemoryUserDetailsManager(userOne, userTwo);
    }

}
