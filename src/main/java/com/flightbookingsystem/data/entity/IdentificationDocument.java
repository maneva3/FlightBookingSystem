package com.flightbookingsystem.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightbookingsystem.data.enums.CountryCode;
import com.flightbookingsystem.data.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "identification_document")
public class IdentificationDocument {
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
    @FutureOrPresent(message = "Expiry date must not be in the past")
    private LocalDate expiryDate;

    @Column(name = "nationality")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Country name is required")
    private CountryCode nationality;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is required")
    private Gender gender;

    @OneToOne(mappedBy = "identificationDocument")
    @NotNull(message = "Personal info must be set!")
    @JsonIgnore
    private PersonalInfo personalInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificationDocument that = (IdentificationDocument) o;
        return Objects.equals(identificationNumber, that.identificationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificationNumber);
    }
}

