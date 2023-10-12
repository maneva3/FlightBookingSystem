package com.flightbookingsystem.web.view.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateCityViewModel {
    @NotBlank(message = "Country code cannot be blank!")
    private String code;

    @NotBlank(message = "City name cannot be blank!")
    private String name;
}
