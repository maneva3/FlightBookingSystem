package com.flightbookingsystem.dto;

<<<<<<< HEAD
public class TicketDTO {
=======
import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.data.enums.LuggageType;
import com.flightbookingsystem.data.enums.TravelClass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TicketDTO {
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
>>>>>>> ec270f741e24252b45f1cd1c66ea0e49cb7792d1
}
