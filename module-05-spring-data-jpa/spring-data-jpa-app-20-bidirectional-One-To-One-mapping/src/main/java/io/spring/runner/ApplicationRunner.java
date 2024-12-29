package io.spring.runner;

import io.spring.dto.UserDTO;
import io.spring.dto.UserProfileDTO;
import io.spring.service.UserService;
import io.spring.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final UserService userService;
    private final UserProfileService userProfileService;

    @Autowired
    public ApplicationRunner(UserService userService, UserProfileService userProfileService) {
        this.userService = userService;
        this.userProfileService = userProfileService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and Save a New User with Profile
        System.out.println("Creating and saving a new user with profile...");
        UserProfileDTO profile = new UserProfileDTO();
        profile.setFirstName("Salman");
        profile.setLastName("Khan");
        profile.setBirthDate(java.time.LocalDate.of(1965, 12, 26));

        UserDTO user = new UserDTO();
        user.setUsername("beingSalman");
        user.setEmail("beingSalman@gmail.com");
        user.setProfile(profile);

        // Save the user
        UserDTO savedUser = userService.saveUser(user);
        System.out.println("\nSaved Successfully:");
        System.out.println(savedUser);

        // Retrieve Profile by ID and Display Associated Data
        System.out.println("\nRetrieving Profile by ID...");
        Long profileId = savedUser.getProfile().getId();

        userProfileService.getUserProfileById(profileId).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No Profile found with ID: " + profileId)
        );
    }
}
