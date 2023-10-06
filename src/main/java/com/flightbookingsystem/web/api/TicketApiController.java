package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.Ticket;
import com.flightbookingsystem.dto.CreateTicketDTO;
import com.flightbookingsystem.dto.TicketDTO;
import com.flightbookingsystem.dto.UpdateTicketDTO;
import com.flightbookingsystem.services.TicketService;
import com.flightbookingsystem.web.view.model.CreateTicketViewModel;
import com.flightbookingsystem.web.view.model.TicketViewModel;
import com.flightbookingsystem.web.view.model.UpdateTicketViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tickets")
public class TicketApiController {
    private final TicketService ticketService;
    private final ModelMapper modelMapper;

    private TicketViewModel convertToTicketViewModel(TicketDTO ticketDTO) {
        return modelMapper.map(ticketDTO, TicketViewModel.class);
    }

    @GetMapping
    public List<TicketDTO> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping("/{bookingReference}")
    public TicketDTO getTicket(@PathVariable("bookingReference") String bookingReference){
        return ticketService.getTicket(bookingReference);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketViewModel ticket) {
        return ticketService.create(modelMapper.map(ticket, CreateTicketDTO.class));
    }

    @PutMapping("/{bookingReference}")
    public Ticket updateTicket(@PathVariable("bookingReference") String bookingReference, @RequestBody UpdateTicketViewModel ticket) {
        return ticketService.updateTicket(bookingReference, modelMapper.map(ticket, UpdateTicketDTO.class));
    }

    @DeleteMapping("/{bookingReference}")
    public void deleteATicket(@PathVariable("bookingReference") String bookingReference) {
        ticketService.deleteTicket(bookingReference);
    }
}
