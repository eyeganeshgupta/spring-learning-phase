package io.spring.service;

import io.spring.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecureCustomerService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(SecureCustomerService.class);

    private final CustomerRepository customerRepository;

    public SecureCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

}
