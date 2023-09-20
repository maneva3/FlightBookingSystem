package com.flightbookingsystem.services;

import jakarta.validation.Valid;

public interface PersonalInfoService {
    List<PersonalInfoDTO> getPersonalInfos();
    PersonalInfoDTO getPersonalInfoById(Long id);
    PersonalInfoDTO createPersonalInfo(@Valid PersonalInfoDTO personalInfoDTO);
    PersonalInfo updatePersonalInfo(Long id, @Valid PersonalInfoDTO personalInfoDTO);
    void deletePersonalInfo(Long id);
}
