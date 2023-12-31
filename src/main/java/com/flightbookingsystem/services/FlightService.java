package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.dto.FlightDTO;
import com.flightbookingsystem.dto.create.CreateFlightDTO;
import com.flightbookingsystem.dto.update.UpdateFlightDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<FlightDTO> getFlights();

    FlightDTO getFlight(@Min(1) Long id);

    Flight create(@Valid CreateFlightDTO createFlightDTO);

    Flight updateFlight(@Min(1) Long id, @Valid UpdateFlightDTO updateFlightDTO);

    void deleteFlight(Long id);

    List<FlightDTO> getFlightsByDepartureAirportName(String name);

    List<FlightDTO> getFlightsByArrivalAirportName(String name);
  
    String getDurationOfFlightAsString(Flight flight);

    List<FlightDTO> getFlightsDepartureAirportCodeAndArrivalAirportCodeAndDepartureDate(String departureAirportCode, String ArrivalAirportCode, LocalDate date);
}
