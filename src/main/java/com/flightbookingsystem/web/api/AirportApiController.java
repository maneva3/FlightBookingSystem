package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.dto.AirportDTO;
import com.flightbookingsystem.dto.create.CreateAirportDTO;
import com.flightbookingsystem.dto.update.UpdateAirportDTO;
import com.flightbookingsystem.services.AirportService;
import com.flightbookingsystem.web.view.model.AirportViewModel;
import com.flightbookingsystem.web.view.model.CreateAirportViewModel;
import com.flightbookingsystem.web.view.model.UpdateAirportViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/airports")
public class AirportApiController {
    private final AirportService airportService;
    private final ModelMapper modelMapper;

    private AirportViewModel convertToAirportViewModel(AirportDTO airportDTO) {
        return modelMapper.map(airportDTO, AirportViewModel.class);
    }

    @GetMapping
    public List<AirportDTO> getAirports() {
        return airportService.getAirports();
    }

    @GetMapping("/{code}")
    public AirportDTO getAirport(@PathVariable("code") String code){
        return airportService.getAirport(code);
    }

    @PostMapping
    public Airport createAirport(@RequestBody CreateAirportViewModel airport) {
        return airportService.create(modelMapper.map(airport, CreateAirportDTO.class));
    }

    @PutMapping("/{code}")
    public Airport updateAirport(@PathVariable("code") String code, @RequestBody UpdateAirportViewModel airport) {
        return airportService.updateAirport(code, modelMapper.map(airport, UpdateAirportDTO.class));
    }

    @DeleteMapping("/{code}")
    public void deleteAirport(@PathVariable("code") String code) {
        airportService.deleteAirport(code);
    }
}
