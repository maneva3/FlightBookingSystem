package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateCountryViewModel {
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Country code cannot be blank!")
    private CountryCode code;

    @NotBlank(message = "Country name cannot be blank!")
    private String name;
}
