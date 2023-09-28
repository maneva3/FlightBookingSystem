package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.repository.AirportRepository;
import com.flightbookingsystem.dto.AirportDTO;
import com.flightbookingsystem.dto.CreateAirportDTO;
import com.flightbookingsystem.dto.UpdateAirportDTO;
import com.flightbookingsystem.exceptions.AirportNotFoundException;
import com.flightbookingsystem.services.AirportService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;

    private AirportDTO convertToAirportDTO(Airport airport) {
        return modelMapper.map(airport, AirportDTO.class);
    }

    @Override
    public List<AirportDTO> getAirports() {
        return airportRepository.findAll().stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AirportDTO getAirport(String code) {
        return modelMapper.map(airportRepository.findById(code)
                .orElseThrow(() -> new AirportNotFoundException("Airport with code " + code + " not found")), AirportDTO.class);
    }

    @Override
    public Airport create(@Valid CreateAirportDTO createAirportDTO) {
        return airportRepository.save(modelMapper.map(createAirportDTO, Airport.class));
    }

    @Override
    public Airport updateAirport(String code, @Valid UpdateAirportDTO updateAirportDTO) {
        Airport airport = modelMapper.map(updateAirportDTO, Airport.class);
        airport.setCode(code);
        return airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(String code) {
        airportRepository.deleteById(code);
    }
}
