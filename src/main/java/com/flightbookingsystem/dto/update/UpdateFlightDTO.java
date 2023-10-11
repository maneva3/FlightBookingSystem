package com.flightbookingsystem.dto.update;

import com.flightbookingsystem.config.DurationConverter;
import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.entity.Ticket;
import com.flightbookingsystem.data.enums.FlightStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateFlightDTO {
    @NotBlank(message = "Flight number cannot be blank!")
    private String flightNumber;

    @NotNull(message = "Departure airport must be set!")
    private Airport departureAirport;

    @NotNull(message = "Arrival airport must be set!")
    private Airport arrivalAirport;

    @NotNull(message = "Departure time must be set!")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival time must be set!")
    private LocalDateTime arrivalTime;

    @NotNull(message = "Flight status must be set!")
    private FlightStatus flightStatus;

    @Positive(message = "Price must be positive!")
    @NotNull(message = "Price must be set!")
    private BigDecimal startingPrice;

    @Convert(converter = DurationConverter.class)
    @NotNull(message = "Duration must be set!")
    private Duration duration;
}
