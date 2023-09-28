package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.User;
import com.flightbookingsystem.dto.UserDTO;
import com.flightbookingsystem.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return user;
//    }

    @Override
    public List<UserDTO> getUsers() {
        return null;
    }

    @Override
    public UserDTO getUserById(String id) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public User updateUser(String id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }
}
