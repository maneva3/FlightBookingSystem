package com.flightbookingsystem.dto.update;

import com.flightbookingsystem.data.entity.PersonalInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateUserDTO {
    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit!")
    @Size(min = 8, max = 64, message = "The password must contain at least 8 characters!")
    private String password;

    @NotNull(message = "Personal info must be set!")
    private PersonalInfo personalInfo;
}
