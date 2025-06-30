package io.spring.controller;

import io.spring.model.BankAccount;
import io.spring.model.Customer;
import io.spring.model.Transaction;
import io.spring.response.ApiResponse;
import io.spring.service.BankService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController {
    private static final Logger log = LoggerFactory.getLogger(BankController.class);

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/customers")
    public ResponseEntity<ApiResponse<Customer>> createCustomer(@Valid @RequestBody Customer customer) {
        Customer createdCustomer = bankService.createCustomer(customer);
        ApiResponse<Customer> response = new ApiResponse<>(true, "Customer created successfully", createdCustomer);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/accounts/{customerId}")
    public ResponseEntity<ApiResponse<BankAccount>> openAccount(@PathVariable Long customerId) {
        BankAccount account = bankService.openAccount(customerId);
        ApiResponse<BankAccount> response = new ApiResponse<>(true, "Account opened successfully", account);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/accounts/{accountId}/deposit")
    public ResponseEntity<ApiResponse<BankAccount>> deposit(@PathVariable Long accountId, @RequestParam double amount) {
        BankAccount account = bankService.deposit(accountId, amount);
        ApiResponse<BankAccount> response = new ApiResponse<>(true, "Amount deposited", account);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/accounts/{accountId}/withdraw")
    public ResponseEntity<ApiResponse<BankAccount>> withdraw(@PathVariable Long accountId, @RequestParam double amount) {
        BankAccount account = bankService.withdraw(accountId, amount);
        ApiResponse<BankAccount> response = new ApiResponse<>(true, "Amount withdrawn", account);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/transfer")
    public ResponseEntity<ApiResponse<String>> transfer(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam double amount) {
        bankService.transfer(fromAccountId, toAccountId, amount);
        ApiResponse<String> response = new ApiResponse<>(true, "Transfer successful", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public ResponseEntity<ApiResponse<List<Transaction>>> getTransactions(@PathVariable Long accountId) {
        List<Transaction> transactions = bankService.getTransactions(accountId);
        ApiResponse<List<Transaction>> response = new ApiResponse<>(true, "Transaction history fetched", transactions);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info")
    public ResponseEntity<ApiResponse<String>> getBankInfo() {
        ApiResponse<String> response = new ApiResponse<>(
                true,
                "Welcome to TrustBank. We offer secure and reliable banking services.",
                "Welcome to TrustBank!"
        );
        return ResponseEntity.ok(response);
    }
}
