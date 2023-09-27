package com.flightbookingsystem.services;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.dto.CreateCreditCardDTO;
import com.flightbookingsystem.dto.CreditCardDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CreditCardService{
    List<CreditCardDTO> getCreditCards();
    CreditCardDTO getCreditCardById(String id);
    CreditCardDTO create(@Valid CreateCreditCardDTO createCreditCardDTO);
    CreditCard updateCreditCard(String id, @Valid CreditCardDTO creditCardDTO);
    void deleteCreditCard(String id);
}
