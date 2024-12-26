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
        UserProfileDTO profile = new UserProfileDTO();
        profile.setFirstName("Ganesh");
        profile.setLastName("Gupta");
        profile.setBirthDate(LocalDate.of(2003, 2, 18));

        UserDTO user = new UserDTO();
        user.setUsername("eyeganeshgupta");
        user.setEmail("eyeganeshgupta@gmail.com");
        user.setProfile(profile);

        // Saving the User
        System.out.println("Saving the following user:");
        System.out.println(user);

        UserDTO savedUser = userService.saveUser(user);

        System.out.println("Saved successfully! Retrieved details:");
        System.out.println(savedUser);

        // Retrieving the saved user by ID
        Long savedUserId = savedUser.getId();

        System.out.println("\nFetching saved user by ID: " + savedUserId);

        var retrievedUser = userService.getUserById(savedUserId);

        retrievedUser.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No user found with ID: " + savedUserId)
        );
    }
}
