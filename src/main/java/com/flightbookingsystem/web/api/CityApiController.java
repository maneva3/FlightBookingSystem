package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.dto.CityDTO;
import com.flightbookingsystem.dto.create.CreateCityDTO;
import com.flightbookingsystem.dto.update.UpdateCityDTO;
import com.flightbookingsystem.services.CityService;
import com.flightbookingsystem.web.view.model.CityViewModel;
import com.flightbookingsystem.web.view.model.CreateCityViewModel;
import com.flightbookingsystem.web.view.model.UpdateCityViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cities")
public class CityApiController {
    private final CityService cityService;
    private final ModelMapper modelMapper;

    private CityViewModel convertToCityViewModel(CityDTO cityDTO) {
        return modelMapper.map(cityDTO, CityViewModel.class);
    }

    @GetMapping
    public List<CityDTO> getCities() {
        return cityService.getCities();
    }

    @GetMapping("/{code}")
    public CityDTO getCity(@PathVariable("code") String code){
        return cityService.getCity(code);
    }

    @PostMapping
    public City createCity(@RequestBody CreateCityViewModel city) {
        return cityService.create(modelMapper.map(city, CreateCityDTO.class));
    }

    @PutMapping("/{code}")
    public City updateCity(@PathVariable("code") String code, @RequestBody UpdateCityViewModel city) {
        return cityService.updateCity(code, modelMapper.map(city, UpdateCityDTO.class));
    }

    @DeleteMapping("/{code}")
    public void deleteCity(@PathVariable("code") String code) {
        cityService.deleteCity(code);
    }


}
