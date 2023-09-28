package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.enums.CountryCode;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.TimeZone;

public interface CityRepository extends JpaRepository<City, String> {
    List<City> findAllCityName(String cityName);
    List<City> findAllCityCode(String cityCode);
    List<City> findAllCityNameStartingWith(String cityName);
    List<City> findAllCityCodeStartingWith(String cityCode);
    List<City> findAllCityNameOrCityCodeStartingWith(String cityName, String cityCode, Sort sort);
    List<City> findCityByCountryName(String countryName);
    List<City> findAllByCountryName(String countryName);
    List<City> findAllByCountryCode(CountryCode countryCode);
    List<City> findAllByTimeZone(TimeZone timeZone);
}
