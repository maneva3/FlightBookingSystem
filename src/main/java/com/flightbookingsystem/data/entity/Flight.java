package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.FlightStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
    private LocalDate departureTime;

    @Column(name = "arrival_time")
    @NotNull(message = "Arrival time must be set!")
    private LocalDate arrivalTime;

    @OneToMany(targetEntity = Ticket.class, mappedBy = "flight")
    private Set<Ticket> ticket;

    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Flight status must be set!")
    private FlightStatus flightStatus = FlightStatus.SCHEDULED;

    public Duration getDuration(){
        return Duration.between(departureTime, arrivalTime).abs();
    }
}
