package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.data.enums.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, CountryCode> {
    List<Country> findAllByName(String countryName);
    List<Country> findAllByCode(CountryCode countryCode);
    Country findCountryByCitiesContains(City city);
    List<Country> findAllByCitiesContains(City city);
}
