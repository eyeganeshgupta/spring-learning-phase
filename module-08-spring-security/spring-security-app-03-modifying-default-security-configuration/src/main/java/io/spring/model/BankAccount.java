package io.spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    private double balance;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    public BankAccount() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Account number is required") String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(@NotBlank(message = "Account number is required") String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
