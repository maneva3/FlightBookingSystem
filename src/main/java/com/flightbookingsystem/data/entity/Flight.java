package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.config.DurationConverter;
import com.flightbookingsystem.data.enums.FlightStatus;
import com.flightbookingsystem.exceptions.InvalidDurationException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number")
    @NotBlank(message = "Flight number cannot be blank!")
    private String flightNumber;

    @ManyToOne(targetEntity = Airport.class)
    @JoinColumn(name = "departure_airport")
    @NotNull(message = "Departure airport must be set!")
    private Airport departureAirport;

    @ManyToOne(targetEntity = Airport.class)
    @JoinColumn(name = "arrival_airport")
    @NotNull(message = "Arrival airport must be set!")
    private Airport arrivalAirport;

    @Column(name = "departure_time")
    @NotNull(message = "Departure time must be set!")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    @NotNull(message = "Arrival time must be set!")
    private LocalDateTime arrivalTime;

    @OneToMany(targetEntity = Ticket.class, mappedBy = "flight")
    private Set<Ticket> tickets;

    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Flight status must be set!")
    private FlightStatus flightStatus = FlightStatus.SCHEDULED;

    @Column(name = "starting_price")
    @Positive(message = "Price must be positive!")
    @NotNull(message = "Starting price must be set!")
    private BigDecimal startingPrice;

    @Column(name = "duration")
    @Convert(converter = DurationConverter.class)
    @NotNull(message = "Duration must be set!")
    private Duration duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
