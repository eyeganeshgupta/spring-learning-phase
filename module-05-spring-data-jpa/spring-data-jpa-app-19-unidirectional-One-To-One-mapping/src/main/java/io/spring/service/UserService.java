package io.spring.service;

import io.spring.dto.UserDTO;
import io.spring.dto.UserProfileDTO;
import io.spring.entity.User;
import io.spring.entity.UserProfile;
import io.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Save a new User
    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    // Find a User by ID
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToDTO);
    }

    // Update an existing User
    public Optional<UserDTO> updateUser(Long id, UserDTO updatedUserDTO) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setUsername(updatedUserDTO.getUsername());
            existingUser.setEmail(updatedUserDTO.getEmail());

            if (updatedUserDTO.getProfile() != null) {
                UserProfile profile = existingUser.getProfile();
                if (profile == null) {
                    profile = new UserProfile();
                    existingUser.setProfile(profile);
                }
                profile.setFirstName(updatedUserDTO.getProfile().getFirstName());
                profile.setLastName(updatedUserDTO.getProfile().getLastName());
                profile.setBirthDate(updatedUserDTO.getProfile().getBirthDate());
            }

            User updatedUser = userRepository.save(existingUser);
            return Optional.of(convertToDTO(updatedUser));
        }

        return Optional.empty();
    }

    // Delete a User by ID
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Retrieve all Users
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());

        if (user.getProfile() != null) {
            UserProfile profile = user.getProfile();

            UserProfileDTO profileDTO = new UserProfileDTO();
            profileDTO.setId(profile.getId());
            profileDTO.setFirstName(profile.getFirstName());
            profileDTO.setLastName(profile.getLastName());
            profileDTO.setBirthDate(profile.getBirthDate());

            userDTO.setProfile(profileDTO);
        }
        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        if (userDTO.getProfile() != null) {
            UserProfile profile = new UserProfile();
            profile.setId(userDTO.getProfile().getId());
            profile.setFirstName(userDTO.getProfile().getFirstName());
            profile.setLastName(userDTO.getProfile().getLastName());
            profile.setBirthDate(userDTO.getProfile().getBirthDate());

            user.setProfile(profile);
        }
        return user;
    }
}
