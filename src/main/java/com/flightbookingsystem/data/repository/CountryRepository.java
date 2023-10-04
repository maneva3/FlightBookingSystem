package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.data.enums.CountryCode;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAllByName(String countryName);
    List<Country> findAllByCode(CountryCode countryCode);
    Country findCountryByCitiesContains(City city);
    List<Country> findAllByCitiesContains(City city);
    List<Country> findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCaseOrderByNameAsc(String name, String code);
}
