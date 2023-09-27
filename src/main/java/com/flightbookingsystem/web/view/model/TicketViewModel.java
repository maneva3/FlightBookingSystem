package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.data.enums.LuggageType;
import com.flightbookingsystem.data.enums.TravelClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class TicketViewModel {
    @NotNull(message = "Booking reference cannot be blank!")
    private String bookingReference;

    @NotNull(message = "Flight must be set!")
    private Flight flight;

    @Pattern(regexp = "([1-9]|[1-3][0-9])[A-F]", message = "Seat must be in format: XX[A-F] or X[A-F]")
    private String seat;

    @Positive(message = "Price must be positive!")
    private BigDecimal startingPrice;

    @NotNull(message = "Choose travel class!")
    private TravelClass travelClass;

    @NotNull(message = "Choose luggage type!")
    private LuggageType luggageType;
}
