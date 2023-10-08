package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.PersonalInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateUserViewModel {
    @NotBlank(message = "Username cannot be blank!")
    @Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
    private String username;

    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit!")
    @Size(min = 8, max = 64, message = "The password must contain at least 8 characters!")
    private String password;
}
