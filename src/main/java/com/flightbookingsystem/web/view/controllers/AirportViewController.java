package com.flightbookingsystem.web.view.controllers;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.dto.AirportDTO;
import com.flightbookingsystem.dto.CreateAirportDTO;
import com.flightbookingsystem.dto.UpdateAirportDTO;
import com.flightbookingsystem.exceptions.AirportNotFoundException;
import com.flightbookingsystem.services.AirportService;
import com.flightbookingsystem.web.view.model.AirportViewModel;
import com.flightbookingsystem.web.view.model.CreateAirportViewModel;
import com.flightbookingsystem.web.view.model.UpdateAirportViewModel;
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
@RequestMapping("/airports")
public class AirportViewController {
    private final AirportService airportService;
    private final ModelMapper modelMapper;

    private AirportViewModel convertToAirportViewModel(AirportDTO airportDTO) {
        return modelMapper.map(airportDTO, AirportViewModel.class);
    }

    @ExceptionHandler({AirportNotFoundException.class})
    public String handleException(AirportNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "error";
    }

    @GetMapping
    public String getAirports(Model model) {
        final List<AirportViewModel> airports = airportService.getAirports()
                .stream()
                .map(this::convertToAirportViewModel)
                .collect(Collectors.toList());
        model.addAttribute("airports", airports);
        return "/airports/airports";
    }

    @GetMapping("/create-airport")
    public String showCreateAirportForm(Model model) {
        model.addAttribute("airport", new AirportViewModel());
        return "/airports/create-airport";
    }

    @GetMapping("/create")
    public String createAirport(@Valid @ModelAttribute("airport") CreateAirportViewModel airport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "airports/create-airport";
        }
        airportService.create(modelMapper.map(airport, CreateAirportDTO.class));
        return "redirect:/airports";
    }

    @GetMapping("/edit-airport")
    public String showUpdateAirportForm(Model model) {
        model.addAttribute("airport", new UpdateAirportViewModel());
        return "/airports/update-airport";
    }

    @GetMapping("/update/{code}")
    public String updateAirport(@PathVariable("code") String code, @Valid @ModelAttribute("airport") UpdateAirportViewModel airport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "airports/update-airport";
        }
        airportService.updateAirport(code, modelMapper.map(airport, UpdateAirportDTO.class));
        return "redirect:/airports";
    }

    @GetMapping("/delete/{code}")
    public String deleteAirport(@PathVariable("code") String code) {
        airportService.deleteAirport(code);
        return "redirect:/airports";
    }
}
