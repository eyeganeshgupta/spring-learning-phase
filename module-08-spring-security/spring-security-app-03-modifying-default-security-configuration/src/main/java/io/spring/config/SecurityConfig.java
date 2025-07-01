package io.spring.config;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
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

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userOne = User.withUsername("ganesh")
                .password("{noop}ganesh")
                .roles("USER")
                .build();

        UserDetails userTwo = User.withUsername("virat")
                .password("{noop}virat")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userOne, userTwo);
    }

}
