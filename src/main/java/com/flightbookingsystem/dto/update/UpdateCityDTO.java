package com.flightbookingsystem.dto.update;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateCityDTO {
    @NotBlank(message = "City code cannot be blank!")
    private String code;

    @NotBlank(message = "City name cannot be blank!")
    private String name;
}
