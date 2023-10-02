package com.flightbookingsystem.dto;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CountryDTO {
    @NotNull(message = "Country id must be set!")
    private Long id;

    @NotNull(message = "Country code must be set!")
    private CountryCode code;

    @NotBlank(message = "Country name cannot be blank!")
    private String name;

    private Set<City> cities;
}
