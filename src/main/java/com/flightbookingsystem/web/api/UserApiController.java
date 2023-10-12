package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.User;
import com.flightbookingsystem.dto.UserDTO;
import com.flightbookingsystem.dto.update.UpdateUserDTO;
import com.flightbookingsystem.services.UserService;
import com.flightbookingsystem.web.view.model.UpdateUserViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserApiController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping("/{username}")
    public UserDTO getUser(@PathVariable("username") String username){
        return userService.getUser(username);
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
