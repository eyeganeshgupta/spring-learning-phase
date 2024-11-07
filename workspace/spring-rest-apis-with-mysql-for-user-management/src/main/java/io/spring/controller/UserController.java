package io.spring.controller;

import io.spring.dto.UserDTO;
import io.spring.response.ApiResponse;
import io.spring.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "User Management APIs",
        description = "APIs for managing user resources including creation, retrieval, updating, and deletion."
)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user using UserDTO
    @Operation(
            summary = "Create a New User",
            description = "This endpoint allows for the creation of a new user in the database."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "201",
            description = "User successfully created."
    )
    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@Valid @RequestBody UserDTO user) {
        user.setRole("USER");
        user.setStatus("ACTIVE");

        UserDTO savedUser = userService.createUser(user);

        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User created successfully", savedUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get a user by ID
    @Operation(
            summary = "Retrieve User by ID",
            description = "Fetches a user from the database using the provided user ID."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "User successfully retrieved."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "404",
            description = "User not found."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);

        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User fetched successfully", user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get all users
    @Operation(
            summary = "Retrieve All Users",
            description = "Fetches a list of all users in the database."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "All users successfully retrieved."
    )
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();

        ApiResponse<List<UserDTO>> response = new ApiResponse<>(true, "All users fetched successfully", users);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Update a user by ID
    @Operation(
            summary = "Update User by ID",
            description = "Allows for the updating of user information using the provided user ID."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "User successfully updated."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "404",
            description = "User not found."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO user) {
        UserDTO updatedUser = userService.updateUser(id, user);

        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User updated successfully", updatedUser);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Delete a user by ID
    @Operation(
            summary = "Delete User by ID",
            description = "Removes a user from the database using the provided user ID."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "User successfully deleted."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "404",
            description = "User not found."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        ApiResponse<String> response = new ApiResponse<>(true, "User deleted successfully", "Deleted");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
