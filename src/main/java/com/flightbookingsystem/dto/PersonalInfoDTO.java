package com.flightbookingsystem.dto;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.data.entity.IdentificationDocument;
import com.flightbookingsystem.data.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonalInfoDTO {
    private IdentificationDocument identificationDocument;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "[0-9]{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    private CreditCard creditCard;

    @NotNull(message = "User is required")
    private User user;
}
