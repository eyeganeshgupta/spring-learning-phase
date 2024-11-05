package io.spring.controller;

import io.spring.dto.UserDTO;
import io.spring.response.ApiResponse;
import io.spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user using UserDTO
    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@Valid @RequestBody UserDTO user) {
        // Set default role and status for new users
        user.setRole("USER");
        user.setStatus("ACTIVE");

        // Call service to create user and return saved UserDTO
        UserDTO savedUser = userService.createUser(user);

        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User created successfully", savedUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get a user by ID, returning a UserDTO
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {
        // Call service to fetch user by ID and convert to UserDTO
        UserDTO user = userService.getUserById(id);

        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User fetched successfully", user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get all users, returning a list of UserDTOs
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
        // Call service to fetch all users and convert them to DTOs
        List<UserDTO> users = userService.getAllUsers();

        ApiResponse<List<UserDTO>> response = new ApiResponse<>(true, "All users fetched successfully", users);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Update a user by ID using UserDTO for both input and output
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO user) {
        // Call service to update the user and return updated UserDTO
        UserDTO updatedUser = userService.updateUser(id, user);

        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User updated successfully", updatedUser);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        // Call service to delete the user by ID
        userService.deleteUser(id);

        ApiResponse<String> response = new ApiResponse<>(true, "User deleted successfully", "Deleted");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
