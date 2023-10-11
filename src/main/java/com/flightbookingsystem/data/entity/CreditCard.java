package com.flightbookingsystem.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightbookingsystem.data.enums.CreditCardType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private PersonalInfo personalInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }
}