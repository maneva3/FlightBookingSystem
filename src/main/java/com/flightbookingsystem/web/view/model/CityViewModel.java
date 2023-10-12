package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.entity.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CityViewModel {
    @NotBlank(message = "City code cannot be blank!")
    private String code;

    @NotBlank(message = "City name cannot be blank!")
    private String name;

    @NotNull(message = "Country must be set!")
    private Country country;

    @NotNull(message = "Time zone must be set!")
    private TimeZone timeZone;

    private Set<Airport> airports;
}
