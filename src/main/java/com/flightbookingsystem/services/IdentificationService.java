package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Identification;
import jakarta.validation.Valid;

public interface IdentificationService {
    List<IdentificationDTO> getIdentifications();
    IdentificationDTO getIdentificationById(String identificationNumber);
    IdentificationDTO createIdentification(@Valid IdentificationDTO identificationDTO);
    Identification updateIdentification(String identificationNumber), @Valid IdentificationDTO identificationDTO);
    void deleteIdentification(String identificationNumber);
}
