package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.data.enums.LuggageType;
import com.flightbookingsystem.data.enums.TravelClass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateTicketViewModel {
    @NotNull(message = "Flight must be set!")
    private Flight flight;

    @Pattern(regexp = "([1-9]|[1-3][0-9])[A-F]", message = "Seat must be in format: XX[A-F] or X[A-F]")
    private String seat;

    @NotNull(message = "Choose travel class!")
    private TravelClass travelClass;

    @NotNull(message = "Choose luggage type!")
    private LuggageType luggageType;
}
