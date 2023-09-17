package com.flightbookingsystem.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    @NotBlank(message = "Airport name cannot be blank!")
    private String name;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city_code")
    @NotNull(message = "City must be set!")
    private City city;

    @OneToMany(targetEntity = Flight.class, mappedBy = "arrivalAirport")
    private Set<Flight> departureFlights;

    @OneToMany(targetEntity = Flight.class, mappedBy = "departureAirport")
    private Set<Flight> arrivalFlights;
}
