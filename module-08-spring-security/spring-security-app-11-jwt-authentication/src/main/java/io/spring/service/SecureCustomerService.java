package io.spring.service;

import io.spring.model.Customer;
import io.spring.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SecureCustomerService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(SecureCustomerService.class);

    private final CustomerRepository customerRepository;

    public SecureCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Attempting to load user by email: {}", username);

        Customer customer = customerRepository.findByEmail(username)
                .orElseThrow(() -> {
                    logger.warn("User not found with email: {}", username);
                    return new UsernameNotFoundException("User not found with email: " + username);
                });

        logger.debug("User found: {} with role: {}", customer.getEmail(), customer.getRole());

        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(customer.getRole())
        );

        return new User(customer.getEmail(), customer.getPassword(), authorities);
    }
}
