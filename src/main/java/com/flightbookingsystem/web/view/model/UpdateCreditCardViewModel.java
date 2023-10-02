package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.enums.CreditCardType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateCreditCardViewModel {
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
}
