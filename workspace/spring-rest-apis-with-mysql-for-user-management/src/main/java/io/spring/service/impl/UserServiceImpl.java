package io.spring.service.impl;

import io.spring.entity.User;
import io.spring.exception.ResourceNotFoundException;
import io.spring.repository.UserRepository;
import io.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        // Fetch existing user from database
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        // Update only necessary fields using Optional.ofNullable for cleaner null checks
        Optional.ofNullable(user.getName()).ifPresent(existingUser::setName);
        Optional.ofNullable(user.getEmail()).ifPresent(existingUser::setEmail);
        Optional.ofNullable(user.getPhoneNumber()).ifPresent(existingUser::setPhoneNumber);
        Optional.ofNullable(user.getGender()).ifPresent(existingUser::setGender);
        Optional.ofNullable(user.getAddress()).ifPresent(existingUser::setAddress);
        Optional.ofNullable(user.getRole()).ifPresent(existingUser::setRole);
        Optional.ofNullable(user.getStatus()).ifPresent(existingUser::setStatus);

        // Save updated user back into database
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
