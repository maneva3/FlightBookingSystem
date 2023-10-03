package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.data.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping
    public List<Country> getClients() {
        return countryRepository.findAll();
    }
}
