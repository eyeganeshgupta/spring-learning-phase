package io.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private final JwtRequestFilter jwtRequestFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        logger.info("Initializing SecurityFilterChain...");

        http.authorizeHttpRequests(requests -> {
            logger.debug("Setting up public endpoints for '/auth/register' and '/auth/login'");
            requests
                    .requestMatchers("/auth/register", "/auth/login").permitAll()
                    .requestMatchers("/auth/account").hasAnyRole("USER", "ADMIN")
                    .requestMatchers("/auth/admin/all-accounts").hasRole("ADMIN")
                    .anyRequest().authenticated();
        });

        http.exceptionHandling(exception -> {
            logger.debug("Configuring custom authentication entry point for unauthorized access.");
            exception.authenticationEntryPoint(jwtAuthenticationEntryPoint);
        });

        http.sessionManagement(session -> {
            logger.debug("Setting session management to STATELESS");
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        logger.info("Registering JwtRequestFilter before UsernamePasswordAuthenticationFilter");
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        logger.debug("Disabling CSRF protection");
        http.csrf(AbstractHttpConfigurer::disable);

        logger.info("SecurityFilterChain initialized successfully.");
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        logger.info("Initializing BCryptPasswordEncoder...");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        logger.info("Retrieving AuthenticationManager from AuthenticationConfiguration");
        return authenticationConfiguration.getAuthenticationManager();
    }

}
