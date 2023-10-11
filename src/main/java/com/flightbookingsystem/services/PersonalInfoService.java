package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.dto.CreatePersonalInfoDTO;
import com.flightbookingsystem.dto.PersonalInfoDTO;
import com.flightbookingsystem.dto.UpdatePersonalInfoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface PersonalInfoService {
    List<PersonalInfoDTO> getPersonalInfos();

    PersonalInfoDTO getPersonalInfo(@Min(1) Long id);

    PersonalInfo create(@Valid CreatePersonalInfoDTO createPersonalInfoDTO);

    PersonalInfo updatePersonalInfo(@Min(1) Long id, @Valid UpdatePersonalInfoDTO updatePersonalInfoDTO);

    void deletePersonalInfo(Long id);

    PersonalInfoDTO getPersonalInfoByPhoneNumber(String phoneNumber);

    PersonalInfoDTO getPersonalInfoByUserUsername(String username);

    List<PersonalInfoDTO> getAllPersonalInfoByFirstName(String firstName);

    List<PersonalInfoDTO> getAllPersonalInfoByLastName(String lastName);

    List<PersonalInfoDTO> getAllPersonalInfoByFirstNameAndLastName(String firstName, String lastName);
}
