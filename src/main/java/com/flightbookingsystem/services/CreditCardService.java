package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.dto.CreateCreditCardDTO;
import com.flightbookingsystem.dto.CreditCardDTO;
import com.flightbookingsystem.dto.UpdateCreditCardDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CreditCardService {
    List<CreditCardDTO> getCreditCards();

    CreditCardDTO getCreditCard(String cardNumber);

    CreditCard create(@Valid CreateCreditCardDTO createCreditCardDTO);

    CreditCard updateCreditCard(String cardNumber, @Valid UpdateCreditCardDTO updateCreditCardDTO);

    void deleteCreditCard(String cardNumber);
}
