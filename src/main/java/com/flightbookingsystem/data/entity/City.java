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
import java.util.TimeZone;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_code")
    private String code;

    @Column(name = "name")
    @NotBlank(message = "City name cannot be blank!")
    private String name;

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "country_id")
    @NotNull(message = "Country must be set!")
    private Country country;

    @Column(name = "airports")
    @OneToMany(targetEntity = Airport.class, mappedBy = "city")
    @JsonIgnore
    private Set<Airport> airports;

    @Column(name = "time_zone")
    @NotNull(message = "Time zone must be set!")
    private TimeZone timeZone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(code, city.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
