package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.CountryCode;
import com.flightbookingsystem.data.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "identification")
public class Identification {
    @Id
    @Column(name = "identification_number")
    @Pattern(regexp = "[a-zA-Z0-9]{13}", message = "Identification number must be 13 symbols")
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

    @Column(name = "nationality")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Country name is required")
    private CountryCode nationality;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is required")
    private Gender gender;

    @OneToOne(mappedBy = "identification")
    private PersonalInfo personalInfo;

}

