package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.data.repository.FlightRepository;
import com.flightbookingsystem.exceptions.FlightNotFoundException;
import com.flightbookingsystem.services.FlightService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    private FlightDTO convertToFlightDTO(Flight flight) {
        return modelMapper.map(flight, FlightDTO.class);
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepository.findAll().stream()
                .map(this::convertToFlightDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO getFlight(@Min(1) Long id) {
        return modelMapper.map(flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight with id " + id + " not found")), FlightDTO.class);
    }

    @Override
    public Flight create(@Valid CreateFlightDTO createFlightDTO) {
        return flightRepository.save(modelMapper.map(createFlightDTO, Flight.class));
    }

    @Override
    public Flight updateFlight(@Min(1) Long id, @Valid UpdateFlightDTO updateFlightDTO) {
        Flight flight = modelMapper.map(updateFlightDTO, Flight.class);
        flight.setId(id);
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
