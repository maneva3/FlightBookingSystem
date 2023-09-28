package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Ticket;
import com.flightbookingsystem.dto.CreateTicketDTO;
import com.flightbookingsystem.dto.TicketDTO;
import com.flightbookingsystem.dto.UpdateTicketDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface TicketService {
    List<TicketDTO> getTickets();

    TicketDTO getTicket(String bookingReference);

    Ticket create(@Valid CreateTicketDTO createTicketDTO);

    Ticket updateTicket(String bookingReference, @Valid UpdateTicketDTO updateTicketDTO);

    void deleteTicket(String bookingReference);
}
