package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.dto.PersonalInfoDTO;
import com.flightbookingsystem.dto.create.CreatePersonalInfoDTO;
import com.flightbookingsystem.dto.update.UpdatePersonalInfoDTO;
import com.flightbookingsystem.services.PersonalInfoService;
import com.flightbookingsystem.web.view.model.CreatePersonalInfoViewModel;
import com.flightbookingsystem.web.view.model.UpdatePersonalInfoViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/personal-info")
public class PersonalInfoApiController {
    private final PersonalInfoService personalInfoService;
    private final ModelMapper modelMapper;

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
