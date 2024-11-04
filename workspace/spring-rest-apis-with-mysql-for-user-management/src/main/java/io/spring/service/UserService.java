package io.spring.service;

import io.spring.dto.UserDTO;
import io.spring.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long id, UserDTO user);
    void deleteUser(Long id);
}
