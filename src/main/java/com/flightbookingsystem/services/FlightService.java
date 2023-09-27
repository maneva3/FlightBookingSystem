package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Flight;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface FlightService {
    List<FlightDTO> getFlights();

    FlightDTO getFlight(@Min(1) Long id);

    Flight create(@Valid CreateFlightDTO createFlightDTO);

    Flight updateFlight(Long id, @Valid UpdateFlightDTO updateFlightDTO);

    void deleteFlight(Long id);
}
