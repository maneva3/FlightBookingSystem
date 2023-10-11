package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.dto.CreateCreditCardDTO;
import com.flightbookingsystem.dto.CreditCardDTO;
import com.flightbookingsystem.dto.UpdateCreditCardDTO;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

public interface CreditCardService {
    List<CreditCardDTO> getCreditCards();

    CreditCardDTO getCreditCard(String cardNumber);

    CreditCard create(@Valid CreateCreditCardDTO createCreditCardDTO);

    CreditCard updateCreditCard(String cardNumber, @Valid UpdateCreditCardDTO updateCreditCardDTO);

    void deleteCreditCard(String cardNumber);

    CreditCardDTO getCreditCardByCardNumber(String cardNumber);

    CreditCardDTO getCreditCardByCardNumberAndCvv(String cardNumber, String cvv);

    CreditCardDTO getCreditCardByCardNumberAndCvvAndExpiryDate(String cardNumber, String cvv, LocalDate expiryDate);

    CreditCardDTO getCreditCardByPersonalInfoFirstName(String firstName);

    CreditCardDTO getCreditCardByPersonalInfoLastName(String lastName);

    CreditCardDTO getCreditCardByPersonalInfoFirstNameAndPersonalInfoLastName(String firstName, String lastName);
}
