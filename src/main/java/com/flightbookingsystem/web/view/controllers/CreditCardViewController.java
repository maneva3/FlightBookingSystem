package com.flightbookingsystem.web.view.controllers;

import com.flightbookingsystem.dto.CreditCardDTO;
import com.flightbookingsystem.dto.CreateCreditCardDTO;
import com.flightbookingsystem.exceptions.CreditCardNotFoundException;
import com.flightbookingsystem.services.CreditCardService;
import com.flightbookingsystem.web.view.model.CreditCardViewModel;
import com.flightbookingsystem.web.view.model.CreateCreditCardViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/creditCard")
public class CreditCardViewController {
    private final CreditCardService creditCardService;
    private final ModelMapper modelMapper;

    private CreditCardViewModel convertToCreditCardViewModel(CreditCardDTO creditCardDTO) {
        return modelMapper.map(creditCardDTO, CreditCardViewModel.class);
    }

    @ExceptionHandler({CreditCardNotFoundException.class})
    public String handleException(CreditCardNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "error";
    }

    @GetMapping
    public String getCreditCards(Model model) {
        final List<CreditCardViewModel> creditCards = creditCardService.getCreditCards()
                .stream()
                .map(this::convertToCreditCardViewModel)
                .collect(Collectors.toList());
        model.addAttribute("creditCards", creditCards);
        return "/creditCards/creditCards";
    }

    @GetMapping("/create-creditCard")
    public String showCreateCreditCardForm(Model model) {
        model.addAttribute("creditCard", new CreditCardViewModel());
        return "/creditCards/create-creditCard";
    }

    @GetMapping("/create")
    public String create(@Valid @ModelAttribute("creditCard") CreateCreditCardViewModel creditCard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "creditCards/create-creditCard";
        }
        creditCardService.create(modelMapper.map(creditCard, CreateCreditCardDTO.class));
        return "redirect:/creditCards";
    }

}
