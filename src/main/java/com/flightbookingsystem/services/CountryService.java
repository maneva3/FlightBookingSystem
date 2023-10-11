package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.dto.CountryDTO;
import com.flightbookingsystem.dto.create.CreateCountryDTO;
import com.flightbookingsystem.dto.update.UpdateCountryDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface CountryService {
    List<CountryDTO> getCountries();

    CountryDTO getCountry(Long id);

    Country create(@Valid CreateCountryDTO createCountryDTO);

    Country updateCountry(@Min(1) Long id, @Valid UpdateCountryDTO updateCountryDTO);

    void deleteCountry(Long id);

    List<CountryDTO> getCountriesByName(String name);

    List<CountryDTO> getCountriesByCode(CountryCode code);

    List<CountryDTO> getCountriesByCity(City cityName);

    CountryDTO getCountryByCity(City cityName);

    List<CountryDTO> getCountriesByNameOrCode(String nameOrCode);
}
