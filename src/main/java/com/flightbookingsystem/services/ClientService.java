package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Client;
import com.flightbookingsystem.dto.ClientDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getClients();
    ClientDTO getClientById(String id);
    ClientDTO createClient(@Valid ClientDTO clientDTO);
    Client updateClient(String id, @Valid ClientDTO clientDTO);
    void deleteClient(String id);
}
