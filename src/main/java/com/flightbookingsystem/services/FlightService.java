package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.dto.CreateFlightDTO;
import com.flightbookingsystem.dto.FlightDTO;
import com.flightbookingsystem.dto.UpdateFlightDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface FlightService {
    List<FlightDTO> getFlights();

    FlightDTO getFlight(@Min(1) Long id);

    Flight create(@Valid CreateFlightDTO createFlightDTO);

    Flight updateFlight(@Min(1) Long id, @Valid UpdateFlightDTO updateFlightDTO);

    void deleteFlight(Long id);

    String getDurationOfFlightAsString(Flight flight);
}
