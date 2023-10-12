package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.Ticket;
import com.flightbookingsystem.data.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, String> {
    Ticket findByFlightFlightNumber(String flightNumber);
    List<Ticket> findAllByFlightFlightNumber(String flightNumber);
    List<Ticket> findAllByUserUsername(String username);
    List<Ticket> findAllByUserUsernameAndFlightFlightNumber(String username, String flightNumber);
    List<Ticket> findAllByFlightFlightStatus(FlightStatus flightStatus);
    List<Ticket> findAllByFlightFlightStatusAndUserUsername(FlightStatus flightStatus, String username);
    List<Ticket> findAllByFlightFlightStatusAndFlightFlightNumber(FlightStatus flightStatus, String flightNumber);
}
