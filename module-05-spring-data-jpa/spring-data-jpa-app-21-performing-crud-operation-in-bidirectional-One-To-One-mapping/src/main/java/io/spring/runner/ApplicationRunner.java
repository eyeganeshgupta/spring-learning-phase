package io.spring.runner;

import io.spring.dto.UserDTO;
import io.spring.dto.UserProfileDTO;
import io.spring.service.UserService;
import io.spring.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        // 1. Create a New User with Profile
        System.out.println("Creating a new User with Profile...");
        UserProfileDTO profileDTO = new UserProfileDTO();
        profileDTO.setFirstName("Jake");
        profileDTO.setLastName("Gyllenhaal");
        profileDTO.setBirthDate(LocalDate.of(1980, 12, 19));

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("jake.gyllenhaal");
        userDTO.setEmail("jakegyllenhaal@gmail.com");
        userDTO.setProfile(profileDTO);

        // Save the User
        UserDTO savedUser = userService.saveUser(userDTO);
        System.out.println("\nUser Saved Successfully:");
        System.out.println(savedUser);

        // 2. Retrieve the User by ID (Owner Side)
        System.out.println("\nRetrieving the saved User by ID...");
        Long savedUserId = savedUser.getId();
        userService.getUserById(savedUserId).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No User found with ID: " + savedUserId)
        );

        // 3. Retrieve the Profile by ID (Inverse Side)
        System.out.println("\nRetrieving the associated Profile by ID...");
        Long profileId = savedUser.getProfile().getId();
        userProfileService.getUserProfileById(profileId).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No Profile found with ID: " + profileId)
        );

        // 4. Update the User's Email
        System.out.println("\nUpdating the User's Email...");
        savedUser.setEmail("jakegyllenhaal@outlook.com");
        UserDTO updatedUser = userService.saveUser(savedUser);
        System.out.println("Updated User:");
        System.out.println(updatedUser);

        // 5. Retrieve All Users (Owner Side)
        System.out.println("\nRetrieving All Users...");
        userService.getAllUsers().forEach(System.out::println);

        // 6. Delete the User
        System.out.println("\nDeleting the User...");
        boolean isDeleted = userService.deleteUserById(savedUserId);
        if (isDeleted) {
            System.out.println("User Deleted Successfully.");
            System.out.println("\nVerifying Deletion...");
            userService.getAllUsers().forEach(System.out::println);
        } else {
            System.out.println("Failed to Delete the User.");
        }
    }
}
