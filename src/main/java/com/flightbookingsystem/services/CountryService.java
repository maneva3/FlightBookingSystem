package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.data.enums.CountryCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface CountryService {
    List<CountryDTO> getCountries();

    CountryDTO getCountry(CountryCode code);

    Country create(@Valid CreateCountryDTO createCountryDTO);

    Country updateCountry(CountryCode code, @Valid UpdateCountryDTO updateCountryDTO);

    void deleteCountry(CountryCode code);
}
