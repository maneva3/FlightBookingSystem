package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.data.enums.CountryCode;
import com.flightbookingsystem.dto.CountryDTO;
import com.flightbookingsystem.dto.CreateCountryDTO;
import com.flightbookingsystem.dto.UpdateCountryDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CountryService {
    List<CountryDTO> getCountries();

    CountryDTO getCountry(CountryCode code);

    Country create(@Valid CreateCountryDTO createCountryDTO);

    Country updateCountry(CountryCode code, @Valid UpdateCountryDTO updateCountryDTO);

    void deleteCountry(CountryCode code);
}
