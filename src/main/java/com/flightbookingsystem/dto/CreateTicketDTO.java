package com.flightbookingsystem.dto;

import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.data.entity.User;
import com.flightbookingsystem.data.enums.LuggageType;
import com.flightbookingsystem.data.enums.TravelClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateTicketDTO{
    @NotBlank(message = "Booking reference cannot be blank!")
    private String bookingReference;

    @NotNull(message = "Flight must be set!")
    private Flight flight;

    @Pattern(regexp = "([1-9]|[1-3][0-9])[A-F]", message = "Seat must be in format: XX[A-F] or X[A-F]")
    private String seat;

    @Positive(message = "Price must be positive!")
    private BigDecimal startingPrice;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Choose travel class!")
    private TravelClass travelClass;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Choose luggage type!")
    private LuggageType luggageType;
}
