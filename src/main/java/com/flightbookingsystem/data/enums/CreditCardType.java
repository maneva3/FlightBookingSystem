package com.flightbookingsystem.data.enums;

import lombok.Getter;

@Getter
public enum CreditCardType {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    AMERICAN_EXPRESS("American Express"),
    UNKNOWN("Unknown");

    private final String creditCardType;

    CreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }
}
