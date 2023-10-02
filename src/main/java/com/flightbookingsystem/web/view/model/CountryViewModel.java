package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CountryViewModel {
    @NotBlank(message = "City code cannot be blank!")
    @Enumerated(EnumType.STRING)
    private CountryCode code;

    @Column(name = "name")
    @NotBlank(message = "Country name cannot be blank!")
    private String name;

    private Set<City> cities;
}