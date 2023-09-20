package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {

}
