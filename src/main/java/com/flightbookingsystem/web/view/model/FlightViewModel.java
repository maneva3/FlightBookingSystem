package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.enums.FlightStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FlightViewModel {
    @NotBlank(message = "Flight number cannot be blank!")
    private String flightNumber;

    @NotNull(message = "Departure airport must be set!")
    private Airport departureAirport;

    @NotNull(message = "Arrival airport must be set!")
    private Airport arrivalAirport;

    @NotNull(message = "Departure time must be set!")
    private LocalDate departureTime;

    @NotNull(message = "Arrival time must be set!")
    private LocalDate arrivalTime;

    @NotNull(message = "Flight status must be set!")
    private FlightStatus flightStatus;
}
