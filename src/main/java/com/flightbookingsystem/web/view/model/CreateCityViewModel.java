package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.Country;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateCityViewModel {
    @NotBlank(message = "Country code cannot be blank!")
    private String code;

    @NotBlank(message = "City name cannot be blank!")
    private String name;

    @NotNull(message = "Country must be set!")
    private Country country;

    @NotNull(message = "Time zone must be set!")
    private TimeZone timeZone;
}
