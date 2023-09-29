package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.CreditCardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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
    @NotNull(message = "Card type is required")
    private CreditCardType cardType;

    @OneToOne(mappedBy = "creditCard")
    @NotNull(message = "Personal info must be set!")
    private PersonalInfo personalInfo;

    //TODO: Add validation for card number, card holder name, expiry date, cvv in the service layer, not here
    public CreditCard(String cardNumber, String cardHolderName, LocalDate expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardType = determineCardType(cardNumber);
    }
    private CreditCardType determineCardType(String cardNumber) {
        if (cardNumber.startsWith("3")) {
            return CreditCardType.AMERICAN_EXPRESS;
        } else if (cardNumber.startsWith("4")) {
            return CreditCardType.VISA;
        } else
            return CreditCardType.MASTERCARD;
    }
}