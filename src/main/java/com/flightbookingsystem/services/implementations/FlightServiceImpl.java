package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.City;
import com.flightbookingsystem.data.entity.Flight;
import com.flightbookingsystem.data.enums.FlightStatus;
import com.flightbookingsystem.data.repository.FlightRepository;
import com.flightbookingsystem.dto.FlightDTO;
import com.flightbookingsystem.dto.create.CreateFlightDTO;
import com.flightbookingsystem.dto.update.UpdateFlightDTO;
import com.flightbookingsystem.exceptions.FlightNotFoundException;
import com.flightbookingsystem.exceptions.InvalidDurationException;
import com.flightbookingsystem.services.FlightService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    private FlightDTO convertToFlightDTO(Flight flight) {
        return modelMapper.map(flight, FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getFlights() {
        return flightRepository.findAll().stream()
                .map(this::convertToFlightDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO getFlight(@Min(1) Long id) {
        return modelMapper.map(flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight with id " + id + " not found")), FlightDTO.class);
    }

    @Override
    public Flight create(@Valid CreateFlightDTO createFlightDTO) {
        Flight createFlight = modelMapper.map(createFlightDTO, Flight.class);
        createFlight.setFlightStatus(FlightStatus.SCHEDULED);
        setDuration(createFlight);
        return flightRepository.save(createFlight);
    }

    @Override
    public Flight updateFlight(@Min(1) Long id, @Valid UpdateFlightDTO updateFlightDTO) {
        Flight flight = modelMapper.map(updateFlightDTO, Flight.class);
        flight.setId(id);
        setDuration(flight);
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public List<FlightDTO> getFlightsByDepartureAirportName(String name) {
        return flightRepository.findAllByDepartureAirportName(name).stream()
                .map(this::convertToFlightDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> getFlightsByArrivalAirportName(String name) {
        return flightRepository.findAllByArrivalAirportName(name).stream()
                .map(this::convertToFlightDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String getDurationOfFlightAsString(Flight flight) {
        return flight.getDuration().toHours() + " hours and " + flight.getDuration().toMinutesPart() + " minutes";
    }

    @Override
    public List<FlightDTO> getFlightsDepartureAirportCodeAndArrivalAirportCodeAndDepartureDate(String departureAirportCode, String ArrivalAirportCode, LocalDate date) {
        return flightRepository.findAllByDepartureAirportCodeAndArrivalAirportCode(departureAirportCode, ArrivalAirportCode)
                .stream()
                .map(this::convertToFlightDTO)
                .filter(flightDTO -> flightDTO.getDepartureTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    private void setDuration(Flight flight){
        City departureCity = flight.getDepartureAirport().getCity();
        City arrivalCity = flight.getArrivalAirport().getCity();

        int timeZoneOffSetInMinutesDepartureCity= departureCity.getTimeZone().getRawOffset() / 60000;
        int timeZoneOffSetInMinutesArrivalCity = arrivalCity.getTimeZone().getRawOffset() / 60000;

        int offSetBetweenAirportsInMinutes = timeZoneOffSetInMinutesDepartureCity - timeZoneOffSetInMinutesArrivalCity;

        LocalDateTime departureTime = flight.getDepartureTime();
        LocalDateTime arrivalTime = flight.getArrivalTime();

        LocalDateTime arrivalTimeWithOffset = arrivalTime.plusMinutes(offSetBetweenAirportsInMinutes);
        Duration flightDuration = Duration.between(departureTime, arrivalTimeWithOffset);

        if (flightDuration.isNegative()){
            throw new InvalidDurationException("Flight duration cannot be negative!");
        }
        flight.setDuration(flightDuration);
    }
}
