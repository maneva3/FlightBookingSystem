package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.IdentificationDocument;
import com.flightbookingsystem.dto.CreateIdentificationDocumentDTO;
import com.flightbookingsystem.dto.IdentificationDocumentDTO;
import com.flightbookingsystem.dto.UpdateIdentificationDocumentDTO;
import jakarta.validation.Valid;
import java.util.List;

public interface IdentificationDocumentService {
    List<IdentificationDocumentDTO> getIdentificationDocuments();

    IdentificationDocumentDTO getIdentificationDocument(String identificationNumber);

    IdentificationDocument create(@Valid CreateIdentificationDocumentDTO createIdentificationDocumentDTO);

    IdentificationDocument updateIdentificationDocument(String identificationNumber, @Valid UpdateIdentificationDocumentDTO updateIdentificationDocumentDTO);

    void deleteIdentificationDocument(String identificationNumber);

    IdentificationDocumentDTO getIdentificationDocumentByFirstNameAndLastName(String firstName, String lastName);

    IdentificationDocumentDTO getIdentificationDocumentByPersonalInfoFirstName(String firstName);

    IdentificationDocumentDTO getIdentificationDocumentByPersonalInfoPhoneNumber(String phoneNumber);

    IdentificationDocumentDTO getIdentificationDocumentByPersonalInfoUserUsername(String username);
}
