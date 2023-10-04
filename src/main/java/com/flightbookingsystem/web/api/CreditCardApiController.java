package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.dto.CreateCreditCardDTO;
import com.flightbookingsystem.dto.CreditCardDTO;
import com.flightbookingsystem.services.CreditCardService;
import com.flightbookingsystem.web.view.model.CreateCreditCardViewModel;
import com.flightbookingsystem.web.view.model.CreditCardViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/creditCard")
public class CreditCardApiController {
    private final CreditCardService creditCardService;
    private final ModelMapper modelMapper;

    private CreditCardViewModel convertToCreditCardViewModel(CreditCardDTO creditCardDTO) {
        return modelMapper.map(creditCardDTO, CreditCardViewModel.class);
    }


    @RequestMapping
    public CreditCardDTO getCreditCard(@PathVariable("cardNumber") String cardNumber){
        return creditCardService.getCreditCard(cardNumber);
    }

    @PostMapping
    public CreditCard createCreditCard(@RequestBody CreateCreditCardViewModel creditCard, BindingResult bindingResult) {
        return creditCardService.create(modelMapper.map(creditCard, CreateCreditCardDTO.class));
    }

    @DeleteMapping("/{cardNumber}")
    public void deleteCreditCard(@PathVariable("cardNumber") String cardNumber) {
        creditCardService.deleteCreditCard(cardNumber);
    }
}
