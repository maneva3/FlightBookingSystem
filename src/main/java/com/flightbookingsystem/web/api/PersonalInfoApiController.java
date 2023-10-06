package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.dto.CreatePersonalInfoDTO;
import com.flightbookingsystem.dto.PersonalInfoDTO;
import com.flightbookingsystem.dto.UpdatePersonalInfoDTO;
import com.flightbookingsystem.services.PersonalInfoService;
import com.flightbookingsystem.web.view.model.CreatePersonalInfoViewModel;
import com.flightbookingsystem.web.view.model.PersonalInfoViewModel;
import com.flightbookingsystem.web.view.model.UpdatePersonalInfoViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/personal-info")
public class PersonalInfoApiController {
    private final PersonalInfoService personalInfoService;
    private final ModelMapper modelMapper;

    private PersonalInfoViewModel convertToPersonalInfoViewModel(PersonalInfoDTO personalInfoDTO) {
        return modelMapper.map(personalInfoDTO, PersonalInfoViewModel.class);
    }


    @GetMapping
    public PersonalInfoDTO getPersonalInfo(@RequestParam Long id){
        return personalInfoService.getPersonalInfo(id);
    }

    @PostMapping
    public PersonalInfo createPersonalInfo(@RequestBody CreatePersonalInfoViewModel personalInfo) {
        return personalInfoService.create(modelMapper.map(personalInfo, CreatePersonalInfoDTO.class));
    }

    @PutMapping("/{id}")
    public PersonalInfo updatePersonalInfo(@PathVariable("id") Long id, @RequestBody UpdatePersonalInfoViewModel personalInfo) {
        return personalInfoService.updatePersonalInfo(id, modelMapper.map(personalInfo, UpdatePersonalInfoDTO.class));
    }

    @DeleteMapping("/{id}")
    public void deletePersonalInfo(@PathVariable("id") Long id) {
        personalInfoService.deletePersonalInfo(id);
    }
}
