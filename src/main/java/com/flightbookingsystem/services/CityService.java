package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Ticket;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface CityService {
    List<CityDTO> getCities();

    CityDTO getCity(String code);

    City create(@Valid CreateCityDTO createCityDTO);

    City updateCity(String code, @Valid UpdateCityDTO updateCityDTO);

    void deleteCity(String code);
}
