package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.User;
import com.flightbookingsystem.dto.UserDTO;
import com.flightbookingsystem.dto.create.CreateUserDTO;
import com.flightbookingsystem.dto.update.UpdateUserDTO;
import jakarta.validation.Valid;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDTO> getUsers();
    UserDTO getUser(String username);
    User create(@Valid CreateUserDTO userDTO);
    User updateUser(String username, @Valid UpdateUserDTO userDTO);
    void deleteUser(String username);
    List<UserDTO> getUserByFirstName(String firstName);

    List<UserDTO> getUserByLastName(String lastName);

    UserDTO getUserByPhoneNumber(String phoneNumber);

    UserDTO getUserByTicket(String bookingReference);
}
