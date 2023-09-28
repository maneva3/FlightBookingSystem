package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.data.repository.PersonalInfoRepository;
import com.flightbookingsystem.services.PersonalInfoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class PersonalInfoServiceImpl implements PersonalInfoService {
    private final PersonalInfoRepository personalInfoRepository;
    private final ModelMapper modelMapper;

    private PersonalInfoDTO convertToPersonalInfoDTO(PersonalInfo personalInfo) {
        return modelMapper.map(personalInfo, PersonalInfoDTO.class);
    }

    @Override
    public List<PersonalInfoDTO> getPersonalInfos() {
        return personalInfoRepository.findAll().stream()
                .map(this::convertToPersonalInfoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonalInfoDTO getPersonalInfo(@Min(1) Long id) {
        return modelMapper.map(personalInfoRepository.findById(id)
                .orElseThrow(() -> new PersonalInfoNotFoundException("PersonalInfo with id " + id + " not found")), PersonalInfoDTO.class);
    }

    @Override
    public PersonalInfo create(@Valid CreatePersonalInfoDTO createPersonalInfoDTO) {
        return personalInfoRepository.save(modelMapper.map(createPersonalInfoDTO, PersonalInfo.class));
    }

    @Override
    public PersonalInfo updatePersonalInfo(@Min(1) Long id, @Valid UpdatePersonalInfoDTO updatePersonalInfoDTO) {
        PersonalInfo personalInfo = modelMapper.map(updatePersonalInfoDTO, PersonalInfo.class);
        personalInfo.setId(id);
        return personalInfoRepository.save(personalInfo);
    }

    @Override
    public void deletePersonalInfo(Long id) {
        personalInfoRepository.deleteById(id);
    }
}
