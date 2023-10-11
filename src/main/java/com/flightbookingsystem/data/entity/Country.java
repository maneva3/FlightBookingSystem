package com.flightbookingsystem.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", unique = true)
    @Enumerated(EnumType.STRING)
    private CountryCode code;

    @Column(name = "name")
    @NotBlank(message = "Country name cannot be blank!")
    private String name;

    @OneToMany(targetEntity = City.class, mappedBy = "country")
    @JsonIgnore
    private Set<City> cities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}