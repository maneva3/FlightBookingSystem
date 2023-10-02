package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.enums.FlightStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateFlightViewModel {
    @NotBlank(message = "Flight number cannot be blank!")
    private String flightNumber;

    @NotNull(message = "Departure time must be set!")
    private LocalDate departureTime;

    @NotNull(message = "Arrival time must be set!")
    private LocalDate arrivalTime;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Flight status must be set!")
    private FlightStatus flightStatus;
}
