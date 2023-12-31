package com.flightbookingsystem.dto;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Flight;
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
public class AirportDTO {
    @NotBlank(message = "Airport code cannot be blank!")
    private String code;

    @NotBlank(message = "Airport name cannot be blank!")
    private String name;

    @NotNull(message = "City must be set!")
    private City city;

    private Set<Flight> departureFlights;

    private Set<Flight> arrivalFlights;
}
