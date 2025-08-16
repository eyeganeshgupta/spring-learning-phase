package io.spring.config;

import io.spring.exceptions.CustomAccessDeniedHandler;
import io.spring.exceptions.CustomAuthenticationEntryPoint;
import io.spring.security.CustomBasicAuthenticationFilter;
import io.spring.security.CustomLoginFailureHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomLoginFailureHandler customLoginFailureHandler;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    public SecurityConfig(CustomLoginFailureHandler customLoginFailureHandler, CustomAuthenticationEntryPoint customAuthenticationEntryPoint, CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.customLoginFailureHandler = customLoginFailureHandler;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        logger.info("Initializing AuthenticationManager bean...");
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        logger.info("Configuring HTTP Security...");

        http.exceptionHandling(exception -> {
            logger.info("Applying custom access denied handler and authentication entry point.");
            exception
                    .accessDeniedHandler(customAccessDeniedHandler)
                    .authenticationEntryPoint(customAuthenticationEntryPoint);
        });

        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(
                        "/auth/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()
                .anyRequest().authenticated()
        );

        http.formLogin(Customizer.withDefaults());

        http.addFilterBefore(
                new CustomBasicAuthenticationFilter(authenticationManager, customLoginFailureHandler),
                BasicAuthenticationFilter.class
        );

        http.httpBasic(Customizer.withDefaults());

        http.httpBasic(httpBasic -> httpBasic
                .authenticationEntryPoint(customAuthenticationEntryPoint)
        );

        http.csrf(AbstractHttpConfigurer::disable);
        logger.info("Security filter chain configured successfully.");
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        logger.info("Initializing Password Encoder bean...");
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
