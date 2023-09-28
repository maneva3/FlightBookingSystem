package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.Identification;
import com.flightbookingsystem.data.repository.IdentificationRepository;
import com.flightbookingsystem.dto.CreateIdentificationDTO;
import com.flightbookingsystem.dto.IdentificationDTO;
<<<<<<< HEAD
import com.flightbookingsystem.dto.UpdateIdentificationDTO;
=======
>>>>>>> ec270f741e24252b45f1cd1c66ea0e49cb7792d1
import com.flightbookingsystem.exceptions.IdentificationNotFoundException;
import com.flightbookingsystem.services.IdentificationService;
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
public class IdentificationServiceImpl implements IdentificationService {
    private final IdentificationRepository identificationRepository;
    private final ModelMapper modelMapper;

    private IdentificationDTO convertToIdentificationDTO(Identification identification) {
        return modelMapper.map(identification, IdentificationDTO.class);
    }

    @Override
    public List<IdentificationDTO> getIdentifications() {
        return identificationRepository.findAll().stream()
                .map(this::convertToIdentificationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IdentificationDTO getIdentification(String identificationNumber) {
        return modelMapper.map(identificationRepository.findById(identificationNumber)
                .orElseThrow(() -> new IdentificationNotFoundException("Identification with number " + identificationNumber + " not found")), IdentificationDTO.class);
    }

    @Override
    public Identification create(@Valid CreateIdentificationDTO createIdentificationDTO) {
        return identificationRepository.save(modelMapper.map(createIdentificationDTO, Identification.class));
    }

    @Override
    public Identification updateIdentification(String identificationNumber, @Valid UpdateIdentificationDTO updateIdentificationDTO) {
        Identification identification = modelMapper.map(updateIdentificationDTO, Identification.class);
        identification.setIdentificationNumber(identificationNumber);
        return identificationRepository.save(identification);
    }

    @Override
    public void deleteIdentification(String identificationNumber) {
        identificationRepository.deleteById(identificationNumber);
    }
}
