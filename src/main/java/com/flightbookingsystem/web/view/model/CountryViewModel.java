package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
public class CountryViewModel {
    @NotBlank(message = "City code cannot be blank!")
    @Enumerated(EnumType.STRING)
    private CountryCode countryCode;

    @Column(name = "name")
    @NotBlank(message = "Country name cannot be blank!")
    private String name;
}