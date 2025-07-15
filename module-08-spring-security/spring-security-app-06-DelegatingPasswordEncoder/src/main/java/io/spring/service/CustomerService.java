package io.spring.service;

import io.spring.constants.MessageConstants;
import io.spring.dto.CustomerDTO;
import io.spring.model.Customer;
import io.spring.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            return MessageConstants.EMAIL_ALREADY_EXISTS;
        }

        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setRole(customerDTO.getRole());

        customerRepository.save(customer);

        return MessageConstants.REGISTRATION_SUCCESS;
    }

    public String registerCustomerNoOp(CustomerDTO customerDTO) {
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            return MessageConstants.EMAIL_ALREADY_EXISTS;
        }

        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword("{noop}" + customerDTO.getPassword());
        customer.setRole(customerDTO.getRole());

        customerRepository.save(customer);

        return MessageConstants.REGISTRATION_SUCCESS;
    }

}
