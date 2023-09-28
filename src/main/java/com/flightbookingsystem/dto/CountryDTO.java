package com.flightbookingsystem.dto;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
    private CountryCode code;

    @NotBlank(message = "Country name cannot be blank!")
    private String name;

    private Set<City> cities;
}
