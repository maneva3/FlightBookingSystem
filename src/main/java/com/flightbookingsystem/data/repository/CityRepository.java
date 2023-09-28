package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.enums.CountryCode;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.TimeZone;

public interface CityRepository extends JpaRepository<City, String> {
    List<City> findAllByName(String name);
    List<City> findAllByNameStartingWith(String cityName);
    List<City> findAllByCodeStartingWith(String cityCode);
    List<City> findAllByNameOrCodeStartingWith(String cityName, String cityCode, Sort sort);
    List<City> findCityByCountryName(String countryName);
    List<City> findAllByCountryName(String countryName);
    List<City> findAllByCountryCode(CountryCode countryCode);
    List<City> findAllByTimeZone(TimeZone timeZone);
}
