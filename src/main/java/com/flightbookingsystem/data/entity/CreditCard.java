package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.CreditCardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @Column(name = "card_number")
    @Pattern(regexp = "[3-5][0-9]{7,18}", message = "Card number must be 8-16 digits")
    private String cardNumber;

    @Column(name = "card_holder_name")
    @NotBlank(message = "Card holder name is required")
    private String cardHolderName;

    @Column(name = "expiry_date")
    @Future(message = "Expiry date must be in the future")
    @NotNull(message = "Expiry date is required")
    private LocalDate expiryDate;

    @Column(name = "cvv")
    @Pattern(regexp = "[0-9]{3}", message = "CVV must be 3 digits")
    @NotBlank(message = "CVV is required")
    private String cvv;

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    private CreditCardType cardType;
}