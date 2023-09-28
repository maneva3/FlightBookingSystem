package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.dto.AirportDTO;
import com.flightbookingsystem.dto.CreateAirportDTO;
import com.flightbookingsystem.dto.UpdateAirportDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface AirportService {
    List<AirportDTO> getAirports();

    AirportDTO getAirport(String code);

    Airport create(@Valid CreateAirportDTO createAirportDTO);

    Airport updateAirport(String code, @Valid UpdateAirportDTO updateAirportDTO);

    void deleteAirport(String code);
}
