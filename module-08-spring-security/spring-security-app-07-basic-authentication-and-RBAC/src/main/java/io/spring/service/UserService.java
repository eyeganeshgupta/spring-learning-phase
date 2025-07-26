package io.spring.service;

import io.spring.entity.Role;
import io.spring.entity.User;
import io.spring.repository.RoleRepository;
import io.spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User create(User user) {
        Set<Role> resolvedRoles = user.getRoles().stream()
                .map(role -> roleRepository.findByName(role.getName()).orElseThrow())
                .collect(Collectors.toSet());
        user.setRoles(resolvedRoles);
        return userRepository.save(user);
    }
}
