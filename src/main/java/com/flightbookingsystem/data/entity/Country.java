package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.persistence.*;
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
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_code")
    private CountryCode countryCode;

    @Column(name = "name")
    @NotNull(message = "Country name must be set!")
    private String name;

    @Column(name = "cities")
    @OneToMany(targetEntity = City.class, mappedBy = "country")
    private Set<City> cities;
}
