package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.dto.CountryDTO;
import com.flightbookingsystem.dto.CreateCountryDTO;
import com.flightbookingsystem.dto.UpdateCountryDTO;
import com.flightbookingsystem.services.CountryService;
import com.flightbookingsystem.web.view.model.CountryViewModel;
import com.flightbookingsystem.web.view.model.CreateCountryViewModel;
import com.flightbookingsystem.web.view.model.UpdateCountryViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/countries")
public class CountryApiController {
    private final CountryService countryService;
    private final ModelMapper modelMapper;

    private CountryViewModel convertToCountryViewModel(CountryDTO countryDTO) {
        return modelMapper.map(countryDTO, CountryViewModel.class);
    }

    @GetMapping
    public List<CountryDTO> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/{id}")
    public CountryDTO getCountry(@PathVariable("id") Long id){
        return countryService.getCountry(id);
    }

    @PostMapping
    public Country createCountry(@RequestBody CreateCountryViewModel country) {
        return countryService.create(modelMapper.map(country, CreateCountryDTO.class));
    }

    @PutMapping("/{code}")
    public Country updateCountry(@PathVariable("code") Long id, @RequestBody UpdateCountryViewModel country) {
        return countryService.updateCountry(id, modelMapper.map(country, UpdateCountryDTO.class));
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteCountry(id);
    }
}
