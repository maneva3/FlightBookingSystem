package com.flightbookingsystem.dto;

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
public class UpdateCityDTO {
    @NotBlank(message = "City code cannot be blank!")
    private String code;

    @NotBlank(message = "City name cannot be blank!")
    private String name;
}
