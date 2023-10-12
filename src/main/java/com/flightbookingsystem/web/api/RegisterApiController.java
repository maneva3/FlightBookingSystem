package com.flightbookingsystem.web.api;


import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.data.entity.Role;
import com.flightbookingsystem.data.entity.User;
import com.flightbookingsystem.dto.create.CreatePersonalInfoDTO;
import com.flightbookingsystem.dto.create.CreateUserDTO;
import com.flightbookingsystem.services.PersonalInfoService;
import com.flightbookingsystem.services.UserService;
import com.flightbookingsystem.web.view.model.CreateUserViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/register")
public class RegisterApiController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PersonalInfoService personalInfoService;

    @PostMapping
    public User createUser(@RequestBody CreateUserViewModel user) {
        CreatePersonalInfoDTO personalInfoDTO = new CreatePersonalInfoDTO(user.getFirstName(), user.getLastName(), user.getPhoneNumber());
        personalInfoService.create(personalInfoDTO);

        Role userRole = new Role();
        userRole.setAuthority("USER");

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        CreateUserDTO createUserDTO = new CreateUserDTO(user.getUsername(), user.getPassword(), modelMapper.map(personalInfoDTO, PersonalInfo.class), roles);
        return userService.create(createUserDTO);
    }
}
