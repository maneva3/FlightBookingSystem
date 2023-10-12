package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.data.entity.Role;
import com.flightbookingsystem.data.entity.User;
import com.flightbookingsystem.dto.create.CreatePersonalInfoDTO;
import com.flightbookingsystem.dto.UserDTO;
import com.flightbookingsystem.dto.create.CreateUserDTO;
import com.flightbookingsystem.dto.update.UpdateUserDTO;
import com.flightbookingsystem.services.PersonalInfoService;
import com.flightbookingsystem.services.UserService;
import com.flightbookingsystem.web.view.model.UserViewModel;
import com.flightbookingsystem.web.view.model.CreateUserViewModel;
import com.flightbookingsystem.web.view.model.UpdateUserViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserApiController {
    private final UserService userService;
    private final PersonalInfoService personalInfoService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

//    @RequestMapping("/{username}")
//    public UserDTO getUser(@PathVariable("username") String username){
//        return userService.getUser(username);
//    }

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

    @PutMapping("/{code}")
    public User updateUser(@PathVariable("code") String code, @RequestBody UpdateUserViewModel user) {
        return userService.updateUser(code, modelMapper.map(user, UpdateUserDTO.class));
    }

    @DeleteMapping("/{code}")
    public void deleteUser(@PathVariable("code") String code) {
        userService.deleteUser(code);
    }

    @GetMapping("/by-ticket")
    public UserDTO getUserByTicket(@RequestParam("bookingReference") String bookingReference) {
        return userService.getUserByTicket(bookingReference);
    }
}
