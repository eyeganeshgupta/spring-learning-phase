package io.spring.controller;

import io.spring.dto.RoleRequest;
import io.spring.dto.UnlockUserRequest;
import io.spring.response.ApiResponse;
import io.spring.service.AdminService;
import io.spring.service.UserRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Admin Controller", description = "Endpoints for administrative actions like role change and user unlock")
@RestController
@RequestMapping("/admin")
@SecurityRequirement(name = "basicAuth")
public class AdminController {

    private final UserRoleService userRoleService;
    private final AdminService adminService;

    public AdminController(UserRoleService userRoleService, AdminService adminService) {
        this.userRoleService = userRoleService;
        this.adminService = adminService;
    }

    @Operation(
            summary = "Change user role",
            description = "Allows an admin to change the role of an existing user"
    )
    @PutMapping("/change-role")
    public ResponseEntity<ApiResponse<String>> changeRole(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request containing username and new role",
                    required = true
            )
            @RequestBody RoleRequest roleRequest) {
        try {
            String message = userRoleService.changeUserRole(roleRequest);
            return ResponseEntity.ok(new ApiResponse<>(true, message, null));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(new ApiResponse<>(false, ex.getMessage(), null));
        }
    }

    @Operation(
            summary = "Unlock user account",
            description = "Unlocks a user account that was previously locked"
    )
    @PostMapping("/unlock-user")
    public ResponseEntity<ApiResponse<String>> unlockUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request containing username to unlock",
                    required = true
            )
            @RequestBody UnlockUserRequest request) {
        try {
            String message = adminService.unlockUserAccount(request.getUsername());
            return ResponseEntity.ok(new ApiResponse<>(true, message, null));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(new ApiResponse<>(false, ex.getMessage(), null));
        }
    }
}
