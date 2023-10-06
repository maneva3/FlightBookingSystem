package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.data.enums.CountryCode;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAllByName(String countryName);
    List<Country> findAllByCode(CountryCode countryCode);
    Country findCountryByCitiesContains(City city);
    List<Country> findAllByCitiesContains(City city);

    @Query("SELECT c FROM Country c WHERE LOWER(c.name) LIKE %?1% OR LOWER(c.code) LIKE %?1% ORDER BY c.name ASC")
    List<Country> findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCaseOrderByNameAsc(String nameOrCode);
}
