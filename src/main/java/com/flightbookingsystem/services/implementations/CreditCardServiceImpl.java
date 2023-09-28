package com.flightbookingsystem.services.implementations;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.dto.CreateCreditCardDTO;
import com.flightbookingsystem.dto.CreditCardDTO;
import com.flightbookingsystem.services.CreditCardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {
    @Override
    public List<CreditCardDTO> getCreditCards() {
        return null;
    }

    @Override
    public CreditCardDTO getCreditCardById(String id) {
        return null;
    }

    @Override
    public CreditCardDTO create(CreateCreditCardDTO createCreditCardDTO) {
        return null;
    }

    @Override
    public CreditCard updateCreditCard(String id, CreditCardDTO creditCardDTO) {
        return null;
    }

    @Override
    public void deleteCreditCard(String id) {

    }
}
