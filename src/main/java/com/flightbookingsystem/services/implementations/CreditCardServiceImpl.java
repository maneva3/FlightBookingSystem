package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.data.enums.CreditCardType;
import com.flightbookingsystem.data.repository.CreditCardRepository;
import com.flightbookingsystem.dto.CreditCardDTO;
import com.flightbookingsystem.dto.create.CreateCreditCardDTO;
import com.flightbookingsystem.dto.update.UpdateCreditCardDTO;
import com.flightbookingsystem.exceptions.CreditCardNotFoundException;
import com.flightbookingsystem.services.CreditCardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
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
        CreditCard creditCard = modelMapper.map(createCreditCardDTO, CreditCard.class);
        creditCard.setCardType(determineCardType(creditCard.getCardNumber()));
        return creditCardRepository.save(creditCard);
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

    @Override
    public CreditCardDTO getCreditCardByCardNumber(String cardNumber) {
       return convertToCreditCardDTO(creditCardRepository.findByCardNumber(cardNumber));
    }

    @Override
    public CreditCardDTO getCreditCardByCardNumberAndCvv(String cardNumber, String cvv) {
        return convertToCreditCardDTO(creditCardRepository.findByCardNumberAndCvv(cardNumber, cvv));
    }

    @Override
    public CreditCardDTO getCreditCardByCardNumberAndCvvAndExpiryDate(String cardNumber, String cvv, LocalDate expiryDate) {
        return convertToCreditCardDTO(creditCardRepository.findByCardNumberAndCvvAndExpiryDate(cardNumber, cvv, expiryDate));
    }

    @Override
    public CreditCardDTO getCreditCardByPersonalInfoFirstName(String firstName) {
        return convertToCreditCardDTO(creditCardRepository.findByPersonalInfoFirstName(firstName));
    }

    @Override
    public CreditCardDTO getCreditCardByPersonalInfoLastName(String lastName) {
        return convertToCreditCardDTO(creditCardRepository.findByPersonalInfoLastName(lastName));
    }

    @Override
    public CreditCardDTO getCreditCardByPersonalInfoFirstNameAndPersonalInfoLastName(String firstName, String lastName) {
       return convertToCreditCardDTO(creditCardRepository.findByPersonalInfoFirstNameAndPersonalInfoLastName(firstName, lastName));
    }

    private CreditCardType determineCardType(String cardNumber) {
        if (cardNumber.startsWith("3")) {
            return CreditCardType.AMERICAN_EXPRESS;
        } else if (cardNumber.startsWith("4")) {
            return CreditCardType.VISA;
        } else if(cardNumber.startsWith("5")) {
            return CreditCardType.MASTERCARD;
        } else
            return CreditCardType.UNKNOWN;
    }
}
