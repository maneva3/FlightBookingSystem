package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.IdentificationDocument;
import com.flightbookingsystem.data.repository.IdentificationDocumentRepository;
import com.flightbookingsystem.dto.CreateIdentificationDocumentDTO;
import com.flightbookingsystem.dto.IdentificationDocumentDTO;
import com.flightbookingsystem.dto.UpdateIdentificationDocumentDTO;
import com.flightbookingsystem.exceptions.IdentificationDocumentNotFoundException;
import com.flightbookingsystem.services.IdentificationDocumentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class IdentificationDocumentServiceImpl implements IdentificationDocumentService {
    private final IdentificationDocumentRepository identificationDocumentRepository;
    private final ModelMapper modelMapper;

    private IdentificationDocumentDTO convertToIdentificationDTO(IdentificationDocument identificationDocument) {
        return modelMapper.map(identificationDocument, IdentificationDocumentDTO.class);
    }

    @Override
    public List<IdentificationDocumentDTO> getIdentificationDocuments() {
        return identificationDocumentRepository.findAll().stream()
                .map(this::convertToIdentificationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IdentificationDocumentDTO getIdentificationDocument(String identificationNumber) {
        return modelMapper.map(identificationDocumentRepository.findById(identificationNumber)
                .orElseThrow(() -> new IdentificationDocumentNotFoundException("IdentificationDocument with number " + identificationNumber + " not found")), IdentificationDocumentDTO.class);
    }

    @Override
    public IdentificationDocument create(@Valid CreateIdentificationDocumentDTO createIdentificationDocumentDTO) {
        return identificationDocumentRepository.save(modelMapper.map(createIdentificationDocumentDTO, IdentificationDocument.class));
    }

    @Override
    public IdentificationDocument updateIdentificationDocument(String identificationNumber, @Valid UpdateIdentificationDocumentDTO updateIdentificationDocumentDTO) {
        IdentificationDocument identificationDocument = modelMapper.map(updateIdentificationDocumentDTO, IdentificationDocument.class);
        identificationDocument.setIdentificationNumber(identificationNumber);
        return identificationDocumentRepository.save(identificationDocument);
    }

    @Override
    public void deleteIdentificationDocument(String identificationNumber) {
        identificationDocumentRepository.deleteById(identificationNumber);
    }
}
