package com.flightbookingsystem.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private Set<Flight> departureFlights;

    @OneToMany(targetEntity = Flight.class, mappedBy = "departureAirport")
    @JsonIgnore
    private Set<Flight> arrivalFlights;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(code, airport.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
