package io.spring.service.impl;

import io.spring.dto.UserDTO;
import io.spring.entity.User;
import io.spring.exception.DuplicateEmailException;
import io.spring.exception.ResourceNotFoundException;
import io.spring.mapper.UserMapper;
import io.spring.repository.UserRepository;
import io.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    // Constants for repeated literals
    private static final String EMAIL_ALREADY_EXISTS = "Email already exists";
    private static final String USER_NOT_FOUND_WITH_ID = "User not found with id: ";

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws DuplicateEmailException {
        // Check if email already exists
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new DuplicateEmailException(EMAIL_ALREADY_EXISTS);
        }

        // Convert DTO to Entity
        User user = UserMapper.convertToEntity(userDTO);

        // Save user entity to database
        User savedUser = userRepository.save(user);

        // Convert saved entity back to DTO
        return UserMapper.convertToDto(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        // Fetch user entity from database
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_WITH_ID + id));

        // Convert entity to DTO and return
        return UserMapper.convertToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // Fetch all users and convert each entity to DTO using stream API
        return userRepository.findAll().stream()
                .map(UserMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // Fetch existing user from database
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_WITH_ID + id));

        // Update fields only if they are present in the DTO
        Optional.ofNullable(userDTO.getName()).ifPresent(existingUser::setName);
        Optional.ofNullable(userDTO.getEmail()).ifPresent(existingUser::setEmail);
        Optional.ofNullable(userDTO.getPhoneNumber()).ifPresent(existingUser::setPhoneNumber);
        Optional.ofNullable(userDTO.getGender()).ifPresent(existingUser::setGender);
        Optional.ofNullable(userDTO.getAddress()).ifPresent(existingUser::setAddress);
        Optional.ofNullable(userDTO.getRole()).ifPresent(existingUser::setRole);
        Optional.ofNullable(userDTO.getStatus()).ifPresent(existingUser::setStatus);

        // Save updated user entity back to the database
        User updatedUser = userRepository.save(existingUser);

        // Convert updated entity back to DTO and return
        return UserMapper.convertToDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        // Check if the user exists before deleting
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(USER_NOT_FOUND_WITH_ID + id);
        }

        // Delete the user by ID
        userRepository.deleteById(id);
    }
}
