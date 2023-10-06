package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.Airport;
import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Country;
import com.flightbookingsystem.dto.CountryDTO;
import com.flightbookingsystem.services.AirportService;
import com.flightbookingsystem.services.CityService;
import com.flightbookingsystem.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/search")
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

    @GetMapping ("search-country/{nameOrCode}")
    List<CountryDTO> searchCountries(@RequestParam("nameOrCode") @PathVariable("nameOrCode") String nameOrCode) {
        return countryService.getCountriesByNameOrCode(nameOrCode);
    }
}

