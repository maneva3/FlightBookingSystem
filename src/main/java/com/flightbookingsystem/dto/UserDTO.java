package com.flightbookingsystem.dto;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.data.entity.Role;
import com.flightbookingsystem.data.entity.Ticket;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    @NotBlank(message = "Username cannot be blank!")
    @Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
    private String username;

//    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit!")
//    @Size(min = 8, max = 64, message = "The password must contain at least 8 characters!")
//    private String password;

    @NotNull(message = "Personal info cannot be null!")
    private PersonalInfo personalInfo;

    private Set<Ticket> tickets;

    private Set<Role> authorities;
}
