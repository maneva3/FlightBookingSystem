package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.User;
import com.flightbookingsystem.dto.UserDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUserById(String id);
    UserDTO createUser(@Valid UserDTO userDTO);
    User updateUser(String id, @Valid UserDTO userDTO);
    void deleteUser(String id);
}
