package com.flightbookingsystem.services;

import jakarta.validation.Valid;

public interface ClientService {
    List<ClientDTO> getClients();
    ClientDTO getClientById(String id);
    ClientDTO createClient(@Valid ClientDTO clientDTO);
    Client updateClient(String id, @Valid ClientDTO clientDTO);
    void deleteClient(String id);
}
