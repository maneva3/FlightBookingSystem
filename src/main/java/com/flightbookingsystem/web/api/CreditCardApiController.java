package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.dto.CreditCardDTO;
import com.flightbookingsystem.dto.create.CreateCreditCardDTO;
import com.flightbookingsystem.dto.update.UpdateCreditCardDTO;
import com.flightbookingsystem.services.CreditCardService;
import com.flightbookingsystem.web.view.model.CreateCreditCardViewModel;
import com.flightbookingsystem.web.view.model.UpdateCreditCardViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/creditCard")
public class CreditCardApiController {
    private final CreditCardService creditCardService;
    private final ModelMapper modelMapper;

    @GetMapping
    public CreditCardDTO getCreditCard(@RequestParam String cardNumber){
        return creditCardService.getCreditCard(cardNumber);
    }

    @PostMapping
    public CreditCard createCreditCard(@RequestBody CreateCreditCardViewModel creditCard) {
        return creditCardService.create(modelMapper.map(creditCard, CreateCreditCardDTO.class));
    }

    @PutMapping("/{cardNumber}")
    public CreditCard updateCreditCard(@PathVariable("cardNumber") String cardNumber, @RequestBody UpdateCreditCardViewModel creditCard) {
        return creditCardService.updateCreditCard(cardNumber, modelMapper.map(creditCard, UpdateCreditCardDTO.class));
    }

    @DeleteMapping("/{cardNumber}")
    public void deleteCreditCard(@PathVariable("cardNumber") String cardNumber) {
        creditCardService.deleteCreditCard(cardNumber);
    }
}
