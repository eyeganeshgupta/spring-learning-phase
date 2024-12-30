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

    // Create or Update a User (Owner Side)
    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    // Retrieve a User by ID (Owner Side)
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToDTO);
    }

    // Retrieve All Users (Owner Side)
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Delete a User by ID (Owner Side)
    public boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Convert User Entity to DTO
    private UserDTO convertToDTO(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());

        if (user.getProfile() != null) {
            UserProfile profile = user.getProfile();
            UserProfileDTO profileDTO = new UserProfileDTO();
            profileDTO.setId(profile.getId());
            profileDTO.setFirstName(profile.getFirstName());
            profileDTO.setLastName(profile.getLastName());
            profileDTO.setBirthDate(profile.getBirthDate());
            profileDTO.setUser(dto); // Maintain bi-directional consistency
            dto.setProfile(profileDTO);
        }
        return dto;
    }

    // Convert User DTO to Entity
    private User convertToEntity(UserDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        if (dto.getProfile() != null) {
            UserProfileDTO profileDTO = dto.getProfile();
            UserProfile profile = new UserProfile();
            profile.setId(profileDTO.getId());
            profile.setFirstName(profileDTO.getFirstName());
            profile.setLastName(profileDTO.getLastName());
            profile.setBirthDate(profileDTO.getBirthDate());
            profile.setUser(user); // Maintain bi-directional consistency
            user.setProfile(profile);
        }
        return user;
    }
}
