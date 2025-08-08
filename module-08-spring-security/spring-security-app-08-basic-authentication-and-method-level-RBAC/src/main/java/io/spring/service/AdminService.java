package io.spring.service;

import io.spring.model.User;
import io.spring.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String unlockUserAccount(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        user.setAccountNonLocked(true);
        user.setFailedAttempts(0);

        userRepository.save(user);
        return "User account unlocked successfully";
    }
}
