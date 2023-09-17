package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.CountryName;
import com.flightbookingsystem.data.enums.Gender;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "identification")
public class Identification {
    @Id
    @Column(name = "identification_number")
    @Pattern(regexp = "[0-9]{13}", message = "Identification number must be 13 digits")
    private String identificationNumber;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Column(name = "date_of_birth")
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Column(name = "expiry_date")
    @NotNull(message = "Expiry date is required")
    @Future(message = "Expiry date must be in the future")
    private LocalDate expiryDate;

    @Column(name = "nalionality")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Country name is required")
    private CountryName nationality;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is required")
    private Gender gender;

}

