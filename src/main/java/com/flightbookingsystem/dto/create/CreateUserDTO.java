package com.flightbookingsystem.dto.create;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.data.entity.Role;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserDTO {
    @NotBlank(message = "Username cannot be blank!")
    @Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
    private String username;

    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit!")
    @Size(min = 8, max = 64, message = "The password must contain at least 8 characters!")
    private String password;

    @NotNull(message = "Personal info must be set!")
    private PersonalInfo personalInfo;

    @NotNull(message = "Authorities must be set!")
    private Set<Role> authorities;
}
