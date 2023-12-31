package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.User;
import com.flightbookingsystem.data.repository.UserRepository;
import com.flightbookingsystem.dto.UserDTO;
import com.flightbookingsystem.dto.create.CreateUserDTO;
import com.flightbookingsystem.dto.update.UpdateUserDTO;
import com.flightbookingsystem.exceptions.UserNotFoundException;
import com.flightbookingsystem.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(String username) {
        return modelMapper.map(userRepository.findById(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found")), UserDTO.class);
    }

    @Override
    public User create(CreateUserDTO createUserDTO) {
        return userRepository.save(modelMapper.map(createUserDTO, User.class));

    }

    @Override
    public User updateUser(String username, UpdateUserDTO updateUserDTO) {
        User user = modelMapper.map(updateUserDTO, User.class);
        user.setUsername(username);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public List<UserDTO> getUserByFirstName(String firstName) {
        return userRepository.findAllByPersonalInfoFirstName(firstName).stream().map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUserByLastName(String lastName) {
        return userRepository.findAllByPersonalInfoLastName(lastName).stream().map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByPhoneNumber(String phoneNumber) {
        return convertToUserDTO(userRepository.findByPersonalInfoPhoneNumber(phoneNumber));
    }

    @Override
    public UserDTO getUserByTicket(String bookingReference) {
        return convertToUserDTO(userRepository.findByTicketBookingReference(bookingReference));
    }
}
