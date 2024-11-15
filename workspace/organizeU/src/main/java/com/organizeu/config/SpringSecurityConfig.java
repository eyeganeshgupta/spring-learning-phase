package com.organizeu.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security configuration class to manage authentication and authorization.
 * Uses Spring Security 6, which introduces several changes in the configuration approach.
 */
@Configuration
@EnableMethodSecurity // Enables method-level security annotations like @PreAuthorize, @Secured, etc.
@AllArgsConstructor
public class SpringSecurityConfig {

    private UserDetailsService userDetailsService;

    // Role names used in the application
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";

    /* private static final String API_PATH = "/api/**"; */

    /**
     * Bean to define the password encoder. BCrypt is used to encode passwords securely.
     * The PasswordEncoder bean is made static to enable Spring to manage it without an instance of this class.
     *
     * @return PasswordEncoder - A BCryptPasswordEncoder instance.
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the security filter chain, managing HTTP security.
     * In Spring Security 6, the SecurityFilterChain replaces the WebSecurityConfigurerAdapter for a more modular approach.
     *
     * @param http - HttpSecurity object to configure web security.
     * @return SecurityFilterChain - The configured security filter chain.
     * @throws Exception - General exception in case of configuration issues.
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disables Cross-Site Request Forgery protection.
                .authorizeHttpRequests(authorize -> {
                    /*
                     * ROLE-BASED AUTHORIZATION
                     * Uncomment the following lines for specific API path access rules.
                     * Assigns roles to different HTTP methods for the specified path pattern.
                     *
                     * authorize.requestMatchers(HttpMethod.POST, API_PATH).hasRole(ROLE_ADMIN);
                     * authorize.requestMatchers(HttpMethod.PUT, API_PATH).hasRole(ROLE_ADMIN);
                     * authorize.requestMatchers(HttpMethod.PATCH, API_PATH).hasAnyRole(ROLE_ADMIN, ROLE_USER);
                     * authorize.requestMatchers(HttpMethod.DELETE, API_PATH).hasRole(ROLE_ADMIN);
                     * authorize.requestMatchers(HttpMethod.GET, API_PATH).permitAll();
                     */
                    authorize.anyRequest().authenticated(); // Requires authentication for all other requests.
                })
                .httpBasic(Customizer.withDefaults()); // Enables HTTP Basic authentication.
        return http.build();
    }

    /**
     * Bean to provide the AuthenticationManager, allowing for custom authentication configurations.
     * The AuthenticationManager is necessary for managing authentication processes within the app.
     *
     * @param configuration - The AuthenticationConfiguration object.
     * @return AuthenticationManager - An instance of AuthenticationManager.
     * @throws Exception - General exception in case of configuration issues.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /*
    /**
     * Example in-memory user details service for testing purposes.
     * Creates two users: 'virat' with ROLE_USER and 'admin' with ROLE_ADMIN.
     * Uncomment to use in-memory authentication instead of the UserDetailsService bean.
     *
     * @return UserDetailsService - An instance of InMemoryUserDetailsManager with test users.
     */
    /*
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
    */
}
