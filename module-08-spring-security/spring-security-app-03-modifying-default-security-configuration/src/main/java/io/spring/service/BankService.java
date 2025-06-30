package io.spring.service;

import io.spring.exception.ApiException;
import io.spring.model.BankAccount;
import io.spring.model.Customer;
import io.spring.model.Transaction;
import io.spring.repository.BankAccountRepository;
import io.spring.repository.CustomerRepository;
import io.spring.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BankService {
    private static final Logger log = LoggerFactory.getLogger(BankService.class);

    private final CustomerRepository customerRepo;
    private final BankAccountRepository accountRepo;
    private final TransactionRepository transactionRepo;

    public BankService(CustomerRepository customerRepo, BankAccountRepository accountRepo, TransactionRepository transactionRepo) {
        this.customerRepo = customerRepo;
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    public Customer createCustomer(Customer customer) {
        log.info("Creating customer: {}", customer.getName());
        return customerRepo.save(customer);
    }

    public BankAccount openAccount(Long customerId) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ApiException("Customer not found"));
        BankAccount account = new BankAccount();
        account.setCustomer(customer);
        account.setBalance(0.0);
        account.setAccountNumber(UUID.randomUUID().toString());
        return accountRepo.save(account);
    }

    public BankAccount deposit(Long accountId, double amount) {
        log.info("Depositing {} to account ID {}", amount, accountId);
        BankAccount account = accountRepo.findById(accountId)
                .orElseThrow(() -> new ApiException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        transactionRepo.save(new Transaction(null, "deposit", amount, account, LocalDateTime.now()));
        return accountRepo.save(account);
    }

    public BankAccount withdraw(Long accountId, double amount) {
        log.info("Withdrawing {} from account ID {}", amount, accountId);
        BankAccount account = accountRepo.findById(accountId)
                .orElseThrow(() -> new ApiException("Account not found"));
        if (account.getBalance() < amount) {
            throw new ApiException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        transactionRepo.save(new Transaction(null, "withdraw", amount, account, LocalDateTime.now()));
        return accountRepo.save(account);
    }

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, double amount) {
        withdraw(fromAccountId, amount);
        deposit(toAccountId, amount);
    }

    public List<Transaction> getTransactions(Long accountId) {
        return transactionRepo.findAllByBankAccountId(accountId);
    }
}
