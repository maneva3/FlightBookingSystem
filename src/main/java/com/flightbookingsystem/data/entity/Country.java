package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.CountryCode;
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
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_code")
    @Enumerated(EnumType.STRING)
    private CountryCode code;

    @Column(name = "name")
    @NotBlank(message = "Country name cannot be blank!")
    private String name;

    @OneToMany(targetEntity = City.class, mappedBy = "country")
    private Set<City> cities;
}
