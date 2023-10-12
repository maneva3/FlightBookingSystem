package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.dto.FlightDTO;
import com.flightbookingsystem.dto.create.CreateFlightDTO;
import com.flightbookingsystem.dto.update.UpdateFlightDTO;
import com.flightbookingsystem.services.FlightService;
import com.flightbookingsystem.web.view.model.CreateFlightViewModel;
import com.flightbookingsystem.web.view.model.FlightViewModel;
import com.flightbookingsystem.web.view.model.SearchFlight;
import com.flightbookingsystem.web.view.model.UpdateFlightViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping("/flight-search")
    public List<FlightDTO> searchFlights(@RequestBody SearchFlight searchFlight){
        String departureAirportCode = searchFlight.getDepartureAirport().getCode();
        String arrivalAirportCode = searchFlight.getArrivalAirport().getCode();
        LocalDate departureTime = searchFlight.getDepartureTime();
        return flightService.getFlightsDepartureAirportCodeAndArrivalAirportCodeAndDepartureTimeDate(departureAirportCode, arrivalAirportCode, departureTime);
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
