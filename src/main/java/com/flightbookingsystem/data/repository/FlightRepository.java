package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByArrivalAirportName(String name);
    List<Flight> findAllByDepartureAirportName(String cityName);
    List<Flight> findAllByDepartureAirportCodeAndArrivalAirportCode(String departureAirportCode, String ArrivalAirportCode);
}
