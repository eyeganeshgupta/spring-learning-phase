package io.spring.service.impl;

import io.spring.entity.User;
import io.spring.exception.DuplicateEmailException;
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
    public User createUser(User user) throws DuplicateEmailException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new DuplicateEmailException("Email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id); // Throws ResourceNotFound if user is not found

        // Update fields only if they are present
        Optional.ofNullable(user.getName()).ifPresent(existingUser::setName);
        Optional.ofNullable(user.getEmail()).ifPresent(existingUser::setEmail);
        Optional.ofNullable(user.getPhoneNumber()).ifPresent(existingUser::setPhoneNumber);
        Optional.ofNullable(user.getGender()).ifPresent(existingUser::setGender);
        Optional.ofNullable(user.getAddress()).ifPresent(existingUser::setAddress);
        Optional.ofNullable(user.getRole()).ifPresent(existingUser::setRole);
        Optional.ofNullable(user.getStatus()).ifPresent(existingUser::setStatus);

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
