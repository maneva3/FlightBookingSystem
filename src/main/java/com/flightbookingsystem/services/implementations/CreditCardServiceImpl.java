package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.data.repository.CreditCardRepository;
import com.flightbookingsystem.dto.CreateCreditCardDTO;
import com.flightbookingsystem.dto.CreditCardDTO;
<<<<<<< HEAD
import com.flightbookingsystem.dto.UpdateCreditCardDTO;
=======
>>>>>>> ec270f741e24252b45f1cd1c66ea0e49cb7792d1
import com.flightbookingsystem.exceptions.CreditCardNotFoundException;
import com.flightbookingsystem.services.CreditCardService;
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
public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final ModelMapper modelMapper;


    private CreditCardDTO convertToCreditCardDTO(CreditCard CreditCard) {
        return modelMapper.map(CreditCard, CreditCardDTO.class);
    }

    @Override
    public List<CreditCardDTO> getCreditCards() {
        return creditCardRepository.findAll().stream()
                .map(this::convertToCreditCardDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CreditCardDTO getCreditCard(String cardNumber) {
        return modelMapper.map(creditCardRepository.findById(cardNumber)
                .orElseThrow(() -> new CreditCardNotFoundException("Credit card with number " + cardNumber + " not found")), CreditCardDTO.class);
    }

    @Override
    public CreditCard create(@Valid CreateCreditCardDTO createCreditCardDTO) {
        return creditCardRepository.save(modelMapper.map(createCreditCardDTO, CreditCard.class));
    }

    @Override
    public CreditCard updateCreditCard(String cardNumber, @Valid UpdateCreditCardDTO updateCreditCardDTO) {
        CreditCard CreditCard = modelMapper.map(updateCreditCardDTO, CreditCard.class);
        CreditCard.setCardNumber(cardNumber);
        return creditCardRepository.save(CreditCard);
    }

    @Override
    public void deleteCreditCard(String cardNumber) {
        creditCardRepository.deleteById(cardNumber);
    }
}
