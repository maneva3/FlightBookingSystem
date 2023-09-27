package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.PersonalInfo;
import com.flightbookingsystem.data.enums.CreditCardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreditCardViewModel {
    @Pattern(regexp = "[3-5][0-9]{7,18}", message = "Card number must be 8-16 digits")
    private String cardNumber;

    @NotBlank(message = "Card holder name is required")
    private String cardHolderName;

    @Future(message = "Expiry date must be in the future")
    @NotNull(message = "Expiry date is required")
    private LocalDate expiryDate;

    @Pattern(regexp = "[0-9]{3}", message = "CVV must be 3 digits")
    @NotBlank(message = "CVV is required")
    private String cvv;

    @Enumerated(EnumType.STRING)
    private CreditCardType cardType;
}