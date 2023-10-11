package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.dto.AirportDTO;
import com.flightbookingsystem.dto.create.CreateAirportDTO;
import com.flightbookingsystem.dto.update.UpdateAirportDTO;
import jakarta.validation.Valid;

import java.util.List;


public interface AirportService {
    List<AirportDTO> getAirports();

    AirportDTO getAirport(String code);

    Airport create(@Valid CreateAirportDTO createAirportDTO);

    Airport updateAirport(String code, @Valid UpdateAirportDTO updateAirportDTO);

    void deleteAirport(String code);

    List<AirportDTO> getAirportsByNameOrCode(String nameOrCode);

    List<AirportDTO> getAirportsByName(String name);

    List<AirportDTO> getAirportsByCityName(String name);

    List<AirportDTO> getAirportsByCityNameStartingWith(String name);

    List<AirportDTO> getAirportsByNameStartingWith(String name);

    List<AirportDTO> getAirportsByCityNameAndNameStartingWith(String cityName, String name);

    List<AirportDTO> getAirportsByNameOrCityNameOrCodeOrCityCodeStartingWith(String cityName, String airportName, String airportCode, String cityCode);

    List<AirportDTO> getAirportsByCityNameOrCode(String cityName, String airportCode);
}
