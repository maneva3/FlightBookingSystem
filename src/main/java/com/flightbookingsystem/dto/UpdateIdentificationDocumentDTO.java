package com.flightbookingsystem.dto;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.data.enums.CountryCode;
import com.flightbookingsystem.data.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateIdentificationDocumentDTO {
    @Pattern(regexp = "[a-zA-Z0-9]{13}", message = "Identification number must be 13 symbols")
    private String identificationNumber;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @FutureOrPresent(message = "Expiry date must not be in the past")
    private LocalDate expiryDate;

    @NotNull(message = "Country name is required")
    private CountryCode nationality;

    @NotNull(message = "Gender is required")
    private Gender gender;
}
