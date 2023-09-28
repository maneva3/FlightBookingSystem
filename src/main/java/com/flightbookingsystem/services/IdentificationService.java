package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Identification;
import com.flightbookingsystem.dto.CreateIdentificationDTO;
import com.flightbookingsystem.dto.IdentificationDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface IdentificationService {
    List<IdentificationDTO> getIdentifications();

    IdentificationDTO getIdentification(String identificationNumber);

    Identification create(@Valid CreateIdentificationDTO createIdentificationDTO);

    Identification updateIdentification(String identificationNumber, @Valid UpdateIdentificationDTO updateIdentificationDTO);

    void deleteIdentification(String identificationNumber);
}
