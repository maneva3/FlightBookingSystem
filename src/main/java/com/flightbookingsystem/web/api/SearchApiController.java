package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.services.AirportService;
import com.flightbookingsystem.services.CityService;
import com.flightbookingsystem.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchApiController {
    private AirportService airportService;
    private CityService cityService;
    private CountryService countryService;

    @GetMapping
    public Map<String, List<?>> searchEntities(@RequestParam("nameOrCode") String nameOrCode) {
        Map<String, List<?>> results = new HashMap<>();
        results.put("airports", airportService.getAirportsByNameOrCode(nameOrCode));
        results.put("cities", cityService.getCitiesByNameOrCode(nameOrCode));
        results.put("countries", countryService.getCountriesByNameOrCode(nameOrCode));
        return results;
    }
}
