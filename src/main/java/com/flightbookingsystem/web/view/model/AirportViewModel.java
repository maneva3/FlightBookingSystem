package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AirportViewModel {
    @NotBlank(message = "Airport code cannot be blank!")
    private String code;

    @NotBlank(message = "Airport name cannot be blank!")
    private String name;

    @NotNull(message = "City must be set!")
    private City city;
}
