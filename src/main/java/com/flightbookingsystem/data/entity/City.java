package com.flightbookingsystem.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;
import java.util.TimeZone;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "name")
    @NotBlank(message = "City name cannot be blank!")
    private String name;

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "country_code")
    @NotNull(message = "Country must be set!")
    private Country country;

    @Column(name = "airports")
    @OneToMany(targetEntity = Airport.class, mappedBy = "city")
    private Set<Airport> airports;

    @Column(name = "time_zone")
    @NotNull(message = "Time zone must be set!")
    private TimeZone timeZone;
}
