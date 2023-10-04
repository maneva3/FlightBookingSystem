package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.dto.CityDTO;
import com.flightbookingsystem.dto.CreateCityDTO;
import com.flightbookingsystem.dto.UpdateCityDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CityService {
    List<CityDTO> getCities();

    CityDTO getCity(String code);

    City create(@Valid CreateCityDTO createCityDTO);

    City updateCity(String code, @Valid UpdateCityDTO updateCityDTO);

    void deleteCity(String code);

    List<CityDTO> getCitiesByNameOrCode(String nameOrCode);
}
