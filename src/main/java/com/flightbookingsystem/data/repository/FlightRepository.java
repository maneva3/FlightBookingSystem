package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.data.enums.CountryCode;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByArrivalAirportName(String name);
    List<Flight> findAllByDepartureAirportName(String cityName);
    List<Flight> findAllByDepartureAirportCodeAndArrivalAirportCode(String departureAirportCode, String ArrivalAirportCode);
}
