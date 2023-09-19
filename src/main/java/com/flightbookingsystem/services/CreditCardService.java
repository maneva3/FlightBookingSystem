package com.flightbookingsystem.services;

import jakarta.validation.Valid;

public interface CreditCardService {
    List<CreditCardDTO> getCreditCards();
    CreditCardDTO getCreditCardById(String id);
    CreditCardDTO createCreditCard(@Valid CreditCardDTO creditCardDTO);
    CreditCard updateCreditCard(String id, @Valid CreditCardDTO creditCardDTO);
    void deleteCreditCard(String id);
}
