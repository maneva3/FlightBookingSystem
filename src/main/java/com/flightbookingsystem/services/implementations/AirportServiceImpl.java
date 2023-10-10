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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Validated
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

    @Override
    public List<AirportDTO> getAirportsByNameOrCode(String nameOrCode) {
        return airportRepository.findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCaseOrderByNameAsc(nameOrCode, nameOrCode).stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AirportDTO> getAirportsByName(String name) {
        return airportRepository.findAllByName(name).stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AirportDTO> getAirportsByCityName(String name) {
        return airportRepository.findAllByCityName(name).stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AirportDTO> getAirportsByCityNameStartingWith(String name) {
        return airportRepository.findAllByCityNameStartingWith(name, Sort.by(Sort.Direction.ASC, "name")).stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AirportDTO> getAirportsByNameStartingWith(String name) {
        return airportRepository.findAllByNameStartingWith(name, Sort.by("name")).stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AirportDTO> getAirportsByCityNameAndNameStartingWith(String cityName, String name) {
        Sort sort = Sort.by(Sort.Order.asc("cityName"), Sort.Order.asc("name"));
        return airportRepository.findAllByCityNameAndNameStartingWith(cityName, name, sort).stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AirportDTO> getAirportsByNameOrCityNameOrCodeOrCityCodeStartingWith(String cityName, String airportName, String airportCode, String cityCode) {
        Sort sort = Sort.by(Sort.Order.asc("cityName"), Sort.Order.asc("airportName"), Sort.Order.asc("airportCode"), Sort.Order.asc("cityCode"));
        return airportRepository.findAllByNameOrCityNameOrCodeOrCityCodeStartingWith(cityName, airportName, airportCode, cityCode, sort).stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AirportDTO> getAirportsByCityNameOrCode(String cityName, String airportCode) {
        return airportRepository.findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCaseOrderByNameAsc(cityName, airportCode).stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList());
    }
}
