package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.dto.*;
import com.flightbookingsystem.services.FlightService;
import com.flightbookingsystem.web.view.model.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/flights")
public class FlightApiController {
    private final FlightService flightService;
    private final ModelMapper modelMapper;

    private FlightViewModel convertToFlightViewModel(FlightDTO flightDTO) {
        return modelMapper.map(flightDTO, FlightViewModel.class);
    }

    @GetMapping
    public List<FlightDTO> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping("/{id}")
    public FlightDTO getFlight(@PathVariable("id") Long id){
        return flightService.getFlight(id);
    }

    @PostMapping
    public Flight createFlight(@RequestBody CreateFlightViewModel flight) {
        return flightService.create(modelMapper.map(flight, CreateFlightDTO.class));
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable("id") Long id, @RequestBody UpdateFlightViewModel flight) {
        return flightService.updateFlight(id, modelMapper.map(flight, UpdateFlightDTO.class));
    }

    @DeleteMapping("/{id}")
    public void deleteAFlight(@PathVariable("id") Long id) {
        flightService.deleteFlight(id);
    }
}
