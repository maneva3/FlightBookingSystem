package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.enums.CountryCode;
import com.flightbookingsystem.data.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class IdentificationViewModel {
    @Pattern(regexp = "[a-zA-Z0-9]{13}", message = "Identification number must be 13 symbols")
    private String identificationNumber;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Expiry date is required")
    @Future(message = "Expiry date must be in the future")
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Country name is required")
    private CountryCode nationality;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is required")
    private Gender gender;
}

