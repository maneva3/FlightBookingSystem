package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.repository.CityRepository;
import com.flightbookingsystem.dto.CityDTO;
import com.flightbookingsystem.dto.create.CreateCityDTO;
import com.flightbookingsystem.dto.update.UpdateCityDTO;
import com.flightbookingsystem.exceptions.CityNotFoundException;
import com.flightbookingsystem.services.CityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
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
    public List<CityDTO> getCitiesByNameOrCode(String nameOrCode) {
        return cityRepository.findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCaseOrderByNameAsc(nameOrCode, nameOrCode).stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }
}
