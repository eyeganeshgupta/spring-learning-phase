package io.spring.service;

import io.spring.dto.RoleRequest;
import io.spring.model.User;
import io.spring.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    private final UserRepository userRepository;

    public UserRoleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String changeUserRole(RoleRequest roleRequest) {
        User user = userRepository.findByUsername(roleRequest.getUsername());

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        user.setRole(roleRequest.getNewRole().toUpperCase());
        userRepository.save(user);

        return "Role updated successfully";
    }
}
