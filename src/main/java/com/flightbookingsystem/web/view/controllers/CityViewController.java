package com.flightbookingsystem.web.view.controllers;

import com.flightbookingsystem.dto.CityDTO;
import com.flightbookingsystem.dto.CreateCityDTO;
import com.flightbookingsystem.dto.UpdateCityDTO;
import com.flightbookingsystem.exceptions.CityNotFoundException;
import com.flightbookingsystem.services.CityService;
import com.flightbookingsystem.web.view.model.CityViewModel;
import com.flightbookingsystem.web.view.model.CreateCityViewModel;
import com.flightbookingsystem.web.view.model.UpdateCityViewModel;
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
@RequestMapping("/cities")
public class CityViewController {
    private final CityService cityService;
    private final ModelMapper modelMapper;

    private CityViewModel convertToCityViewModel(CityDTO cityDTO) {
        return modelMapper.map(cityDTO, CityViewModel.class);
    }

    @ExceptionHandler({CityNotFoundException.class})
    public String handleException(CityNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "error";
    }

    @GetMapping
    public String getCities(Model model) {
        final List<CityViewModel> cities = cityService.getCities()
                .stream()
                .map(this::convertToCityViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cities", cities);
        return "/cities/cities";
    }

    @GetMapping("/create-city")
    public String showCreateCityForm(Model model) {
        model.addAttribute("city", new CityViewModel());
        return "/cities/create-city";
    }

    @GetMapping("/create")
    public String createCity(@Valid @ModelAttribute("city") CreateCityViewModel city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cities/create-city";
        }
        cityService.create(modelMapper.map(city, CreateCityDTO.class));
        return "redirect:/cities";
    }

    @GetMapping("/edit-city")
    public String showUpdateCityForm(Model model) {
        model.addAttribute("city", new UpdateCityViewModel());
        return "/cities/update-city";
    }

    @GetMapping("/update/{code}")
    public String updateCity(@PathVariable("code") String code, @Valid @ModelAttribute("city") UpdateCityViewModel city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cities/update-city";
        }
        cityService.updateCity(code, modelMapper.map(city, UpdateCityDTO.class));
        return "redirect:/cities";
    }

    @GetMapping("/delete/{code}")
    public String deleteCity(@PathVariable("code") String code) {
        cityService.deleteCity(code);
        return "redirect:/cities";
    }
}
