package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
