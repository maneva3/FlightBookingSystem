package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.Identification;
import com.flightbookingsystem.dto.CreateIdentificationDTO;
import com.flightbookingsystem.dto.IdentificationDTO;
<<<<<<< HEAD
import com.flightbookingsystem.dto.UpdateIdentificationDTO;
=======
>>>>>>> ec270f741e24252b45f1cd1c66ea0e49cb7792d1
import jakarta.validation.Valid;

import java.util.List;

public interface IdentificationService {
    List<IdentificationDTO> getIdentifications();

    IdentificationDTO getIdentification(String identificationNumber);

    Identification create(@Valid CreateIdentificationDTO createIdentificationDTO);

    Identification updateIdentification(String identificationNumber, @Valid UpdateIdentificationDTO updateIdentificationDTO);

    void deleteIdentification(String identificationNumber);
}
