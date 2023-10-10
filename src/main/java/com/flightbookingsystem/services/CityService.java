package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.enums.CountryCode;
import com.flightbookingsystem.dto.CityDTO;
import com.flightbookingsystem.dto.CreateCityDTO;
import com.flightbookingsystem.dto.UpdateCityDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.TimeZone;

public interface CityService {
    List<CityDTO> getCities();

    CityDTO getCity(String code);

    City create(@Valid CreateCityDTO createCityDTO);

    City updateCity(String code, @Valid UpdateCityDTO updateCityDTO);

    void deleteCity(String code);

    List<CityDTO> getCitiesByName(String name);

    List<CityDTO> getCitiesByNameStartingWith(String name);

    List<CityDTO> getCitiesByCodeStartingWith(String code);

    List<CityDTO> getCitiesByNameOrCodeStartingWith(String name, String code);

    List<CityDTO> getCitiesByCountryName(String countryName);

    List<CityDTO> getCitiesByCountryCode(CountryCode countryCode);

    List<CityDTO> getCitiesByTimeZone(TimeZone timeZone);

    List<CityDTO> getCitiesByNameOrCode(String nameOrCode);
}
