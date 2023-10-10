package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.enums.CountryCode;
import com.flightbookingsystem.data.repository.CityRepository;
import com.flightbookingsystem.dto.CityDTO;
import com.flightbookingsystem.dto.CreateCityDTO;
import com.flightbookingsystem.dto.UpdateCityDTO;
import com.flightbookingsystem.exceptions.CityNotFoundException;
import com.flightbookingsystem.services.CityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    private CityDTO convertToCityDTO(City city) {
        return modelMapper.map(city, CityDTO.class);
    }

    @Override
    public List<CityDTO> getCities() {
        return cityRepository.findAll().stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CityDTO getCity(String code) {
        return modelMapper.map(cityRepository.findById(code)
                .orElseThrow(() -> new CityNotFoundException("City with code " + code + " not found")), CityDTO.class);
    }

    @Override
    public City create(@Valid CreateCityDTO createCityDTO) {
        return cityRepository.save(modelMapper.map(createCityDTO, City.class));
    }

    @Override
    public City updateCity(String code, @Valid UpdateCityDTO updateCityDTO) {
        City city = modelMapper.map(updateCityDTO, City.class);
        city.setCode(code);
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(String code) {
        cityRepository.deleteById(code);
    }

    @Override
    public List<CityDTO> getCitiesByName(String name) {
        return cityRepository.findAllByName(name).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDTO> getCitiesByNameStartingWith(String name) {
        return cityRepository.findAllByNameStartingWith(name).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDTO> getCitiesByCodeStartingWith(String code) {
        return cityRepository.findAllByCodeStartingWith(code).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDTO> getCitiesByNameOrCodeStartingWith(String name, String code) {
        Sort sort = Sort.by(Sort.Order.asc("name"), Sort.Order.asc("code"));
        return cityRepository.findAllByNameOrCodeStartingWith(name, code, sort).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDTO> getCitiesByCountryName(String countryName) {
        return cityRepository.findAllByCountryName(countryName).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDTO> getCitiesByCountryCode(CountryCode countryCode) {
        return cityRepository.findAllByCountryCode(countryCode).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDTO> getCitiesByTimeZone(TimeZone timeZone) {
        return cityRepository.findAllByTimeZone(timeZone).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDTO> getCitiesByNameOrCode(String nameOrCode) {
        return cityRepository.findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCaseOrderByNameAsc(nameOrCode, nameOrCode).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }
}
