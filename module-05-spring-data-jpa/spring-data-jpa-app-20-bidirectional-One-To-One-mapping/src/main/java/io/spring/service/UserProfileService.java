package io.spring.service;

import io.spring.dto.UserDTO;
import io.spring.dto.UserProfileDTO;
import io.spring.entity.UserProfile;
import io.spring.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public Optional<UserProfileDTO> getUserProfileById(Long profileId) {
        Optional<UserProfile> profile = userProfileRepository.findById(profileId);
        return profile.map(this::convertToDto);
    }

    private UserProfileDTO convertToDto(UserProfile profile) {
        if (profile == null) return null;

        UserProfileDTO profileDTO = new UserProfileDTO();

        profileDTO.setId(profile.getId());
        profileDTO.setFirstName(profile.getFirstName());
        profileDTO.setLastName(profile.getLastName());
        profileDTO.setBirthDate(profile.getBirthDate());

        // Map associated User (if exists)
        if (profile.getUser() != null) {
            UserDTO userDTO = new UserDTO();

            userDTO.setId(profile.getUser().getId());
            userDTO.setUsername(profile.getUser().getUsername());
            userDTO.setEmail(profile.getUser().getEmail());

            // Set bi-directional relationship in DTO
            profileDTO.setUser(userDTO);
            userDTO.setProfile(profileDTO);
        }

        return profileDTO;
    }
}
