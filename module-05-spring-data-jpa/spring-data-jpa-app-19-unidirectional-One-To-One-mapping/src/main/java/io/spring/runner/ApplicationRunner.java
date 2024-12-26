package io.spring.runner;

import io.spring.dto.UserDTO;
import io.spring.dto.UserProfileDTO;
import io.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public ApplicationRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save a new User with Profile
        System.out.println("Creating and saving a new user...");

        UserProfileDTO profile1 = new UserProfileDTO();
        profile1.setFirstName("Ganesh");
        profile1.setLastName("Gupta");
        profile1.setBirthDate(LocalDate.of(2003, 2, 18));

        UserDTO user1 = new UserDTO();
        user1.setUsername("eyeganeshgupta");
        user1.setEmail("eyeganeshgupta@gmail.com");
        user1.setProfile(profile1);

        // Save the first User
        UserDTO savedUser1 = userService.saveUser(user1);

        System.out.println("Saved successfully! Retrieved details:");
        System.out.println(savedUser1);

        // Fetch all Users
        System.out.println("\nFetching all users...");

        var allUsers = userService.getAllUsers();

        allUsers.forEach(System.out::println);

        // Update the first user's email and username
        System.out.println("\nUpdating the first user's email and username...");

        savedUser1.setEmail("updated_ganesh@example.com");
        savedUser1.setUsername("updated_eyeganeshgupta");

        var updatedUser1 = userService.updateUser(savedUser1.getId(), savedUser1);

        updatedUser1.ifPresentOrElse(
                u -> System.out.println("Updated successfully! Details:\n" + u),
                () -> System.out.println("Failed to update the user's details.")
        );

        // Delete the first user
        System.out.println("\nDeleting the first user...");

        boolean isDeleted = userService.deleteUser(savedUser1.getId());

        if (isDeleted) {
            System.out.println("Deleted successfully!");

            System.out.println("\nFetching all users after deletion...");

            var remainingUsers = userService.getAllUsers();

            remainingUsers.forEach(System.out::println);

        } else {
            System.out.println("Failed to delete the user's details.");
        }
    }
}
