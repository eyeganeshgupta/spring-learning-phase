package io.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private static final Map<String, Double> accounts = Map.of(
            "eyeganeshgupta@gmail.com", 1050.75,
            "eyeviratgupta@gmail.com", 2540.00
    );

    @GetMapping("/balance")
    public String getAccountBalance(Authentication authentication) {
        String username = authentication.getName();
        logger.info("Fetching account balance for user: {}", username);
        Double balance = accounts.getOrDefault(username, 0.0);
        logger.info("User: {} has balance: ₹{}", username, balance);
        return "Hello " + username + ", your current balance is ₹" + balance;
    }

    @GetMapping("/all")
    public Object getAllAccounts(Authentication authentication) {
        String username = authentication.getName();
        logger.info("User {} is attempting to access all account data", username);

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equalsIgnoreCase("ROLE_ADMIN"));

        if (isAdmin) {
            logger.info("Access granted to user {} for viewing all accounts", username);
            return accounts;
        } else {
            logger.info("Access denied to user {} for viewing all accounts", username);
            return Map.of("error", "Access denied. Admins only.");
        }
    }

    @PostMapping("/transfer")
    public String transferMoney(@RequestParam String toUser,
                                @RequestParam double amount,
                                Authentication authentication) {
        String fromUser = authentication.getName();
        logger.info("Transfer requested: from {} to {} amount ₹{}", fromUser, toUser, amount);
        return "₹" + amount + " has been transferred from " + fromUser + " to " + toUser + ".";
    }
}
