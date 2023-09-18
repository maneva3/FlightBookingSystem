package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Ticket;
import jakarta.validation.Valid;

import java.util.List;

public interface TicketService {
    List<TicketDTO> getTickets();

    TicketDTO getTicket(@Valid String bookingReference);

    Ticket create(@Valid CreateTicketDTO createTicketDTO);

    Ticket updateTicket(String bookingReference, @Valid UpdateTicketDTO updateTicketDTO);

    void deleteTicket(String bookingReference);
}
