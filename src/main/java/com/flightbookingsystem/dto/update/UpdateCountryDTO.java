package com.flightbookingsystem.dto.update;

import com.flightbookingsystem.data.enums.CountryCode;
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
public class UpdateCountryDTO {
    @NotNull(message = "Country code must be set!")
    private CountryCode code;

    @NotBlank(message = "Country name cannot be blank!")
    private String name;
}
