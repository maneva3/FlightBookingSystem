package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.PersonalInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface PersonalInfoService {
    List<PersonalInfoDTO> getPersonalInfos();

    PersonalInfoDTO getPersonalInfo(@Min(1) Long id);

    PersonalInfo create(@Valid CreatePersonalInfoDTO createPersonalInfoDTO);

    PersonalInfo updatePersonalInfo(@Min(1) Long id, @Valid UpdatePersonalInfoDTO updatePersonalInfoDTO);

    void deletePersonalInfo(Long id);
}
