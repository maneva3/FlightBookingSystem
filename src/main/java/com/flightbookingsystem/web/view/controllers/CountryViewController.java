package com.flightbookingsystem.web.view.controllers;

import com.flightbookingsystem.data.enums.CountryCode;
import com.flightbookingsystem.dto.CityDTO;
import com.flightbookingsystem.dto.CountryDTO;
import com.flightbookingsystem.dto.CreateCityDTO;
import com.flightbookingsystem.dto.CreateCountryDTO;
import com.flightbookingsystem.dto.UpdateCountryDTO;
import com.flightbookingsystem.exceptions.CityNotFoundException;
import com.flightbookingsystem.exceptions.CountryNotFoundException;
import com.flightbookingsystem.services.CityService;
import com.flightbookingsystem.services.CountryService;
import com.flightbookingsystem.web.view.model.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/countries")
public class CountryViewController {
    private final CountryService countryService;
    private final ModelMapper modelMapper;

    private CountryViewModel convertToCountryViewModel(CountryDTO countryDTO) {
        return modelMapper.map(countryDTO, CountryViewModel.class);
    }

    @ExceptionHandler({CountryNotFoundException.class})
    public String handleException(CountryNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "error";
    }

    @GetMapping
    public String getCountries(Model model) {
        final List<CountryViewModel> countries = countryService.getCountries()
                .stream()
                .map(this::convertToCountryViewModel)
                .collect(Collectors.toList());
        model.addAttribute("countries", countries);
        return "/countries/countries";
    }

    @GetMapping("/create-country")
    public String showCreateCountryForm(Model model) {
        model.addAttribute("country", new CountryViewModel());
        return "/countries/create-country";
    }

    @GetMapping("/create")
    public String createCountry(@Valid @ModelAttribute("country") CreateCountryViewModel country, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "countries/create-country";
        }
        countryService.create(modelMapper.map(country, CreateCountryDTO.class));
        return "redirect:/countries";
    }

    @GetMapping("/edit-country")
    public String showUpdateCountryForm(Model model) {
        model.addAttribute("country", new UpdateCountryViewModel());
        return "/countries/update-country";
    }

    @GetMapping("/update/{code}")
    public String updateCountry(@PathVariable("code") CountryCode code, @Valid @ModelAttribute("country") UpdateCountryViewModel country, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "countries/update-country";
        }
        countryService.updateCountry(code, modelMapper.map(country, UpdateCountryDTO.class));
        return "redirect:/countries";
    }

    @GetMapping("/delete/{code}")
    public String deleteCountry(@PathVariable("code") CountryCode code) {
        countryService.deleteCountry(code);
        return "redirect:/countries";
    }
}
