package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Ticket;
import com.flightbookingsystem.dto.TicketDTO;
import com.flightbookingsystem.dto.create.CreateTicketDTO;
import com.flightbookingsystem.dto.update.UpdateTicketDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface TicketService {
    List<TicketDTO> getTickets();

    TicketDTO getTicket(String bookingReference);

    Ticket create(@Valid CreateTicketDTO createTicketDTO);

    Ticket updateTicket(String bookingReference, @Valid UpdateTicketDTO updateTicketDTO);

    void deleteTicket(String bookingReference);

    TicketDTO getTicketByFlightNumber(String flightNumber);

    List<TicketDTO> getTicketsByFlightNumber(String flightNumber);

    List<TicketDTO> getTicketsByUsername(String username);

    List<TicketDTO> getTicketsByFlightNumberAndUsername(String flightNumber, String username);

    List<TicketDTO> getTicketsByFlightStatus(String flightStatus);

    List<TicketDTO> getTicketsByFlightStatusAndUsername(String flightStatus, String username);

    List<TicketDTO> getTicketsByFlightStatusAndFlightNumber(String flightStatus, String flightNumber);
}
