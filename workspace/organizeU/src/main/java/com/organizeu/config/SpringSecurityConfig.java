package com.organizeu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";

    private static final String API_PATH = "/api/**";

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(HttpMethod.POST, API_PATH).hasRole(ROLE_ADMIN);
                    authorize.requestMatchers(HttpMethod.PUT, API_PATH).hasRole(ROLE_ADMIN);
                    authorize.requestMatchers(HttpMethod.PATCH, API_PATH).hasAnyRole(ROLE_ADMIN, ROLE_USER);
                    authorize.requestMatchers(HttpMethod.DELETE, API_PATH).hasRole(ROLE_ADMIN);
                    authorize.requestMatchers(HttpMethod.GET, API_PATH).permitAll();
                    authorize.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails virat = User.builder()
                .username("virat")
                .password(passwordEncoder().encode("password"))
                .roles(ROLE_USER)
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(ROLE_ADMIN)
                .build();

        return new InMemoryUserDetailsManager(virat, admin);
    }
}
