package io.spring.service;

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

    // Retrieve a Profile by ID (Inverse Side)
    public Optional<UserProfileDTO> getUserProfileById(Long id) {
        Optional<UserProfile> profile = userProfileRepository.findById(id);
        return profile.map(this::convertToDto);
    }

    // Convert Profile Entity to DTO
    private UserProfileDTO convertToDto(UserProfile profile) {
        if (profile == null) return null;

        // Map Profile to DTO
        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(profile.getId());
        dto.setFirstName(profile.getFirstName());
        dto.setLastName(profile.getLastName());
        dto.setBirthDate(profile.getBirthDate());

        // Map Associated User
        if (profile.getUser() != null) {
            dto.setUser(null); // Avoid recursion by not including full `user`
        }

        return dto;
    }
}
