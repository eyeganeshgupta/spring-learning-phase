package io.spring.service;

import io.spring.dto.UserDTO;
import io.spring.dto.UserProfileDTO;
import io.spring.entity.User;
import io.spring.entity.UserProfile;
import io.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToDTO);
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
