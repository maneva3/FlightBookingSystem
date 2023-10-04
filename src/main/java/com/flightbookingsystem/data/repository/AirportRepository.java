package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.Airport;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AirportRepository extends JpaRepository<Airport, String> {
    List<Airport> findAllByName(String name);
    List<Airport> findAllByCityName(String name);
    List<Airport> findAllByCityNameStartingWith(String name, Sort sort);
    List<Airport> findAllByNameStartingWith(String name, Sort sort);
    List<Airport> findAllByCityNameAndNameStartingWith(String cityName, String name, Sort sort);
    List<Airport> findAllByNameOrCityNameOrCodeOrCityCodeStartingWith(String cityName, String airportName, String airportCode, String cityCode, Sort sort);
    List<Airport> findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCaseOrderByNameAsc(String name, String code);
}
