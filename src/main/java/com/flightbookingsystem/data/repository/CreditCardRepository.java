package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
    CreditCard findByCardNumber(String creditCardNumber);
    CreditCard findByCardNumberAndCvv(String creditCardNumber, String cvv);
    CreditCard findByCardNumberAndCvvAndExpiryDate(String creditCardNumber, String cvv, LocalDate expiryDate);
    CreditCard findByPersonalInfoFirstName(String firstName);
    CreditCard findByPersonalInfoLastName(String lastName);
    CreditCard findByPersonalInfoFirstNameAndPersonalInfoLastName(String firstName, String lastName);

}
