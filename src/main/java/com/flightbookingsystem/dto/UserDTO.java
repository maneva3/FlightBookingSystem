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

    @NotNull(message = "Personal info cannot be null!")
    private PersonalInfo personalInfo;

    private Set<Ticket> tickets;

    private Set<Role> authorities;
}
