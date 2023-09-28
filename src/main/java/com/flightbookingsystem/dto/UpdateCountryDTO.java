package com.flightbookingsystem.dto;

import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateCountryDTO {
    private CountryCode code;

    @NotBlank(message = "Country name cannot be blank!")
    private String name;
}
