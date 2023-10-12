package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.Airport;
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
public class SearchFlight {
    @NotNull(message = "Departure airport must be set!")
    private Airport departureAirport;

    @NotNull
    private Airport arrivalAirport;

    @NotNull
    private LocalDate departureDate;
}
