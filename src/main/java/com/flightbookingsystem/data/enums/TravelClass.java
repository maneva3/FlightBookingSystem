package com.flightbookingsystem.data.enums;

import lombok.Getter;

@Getter
public enum TravelClass {
    ECONOMY("Economy"),
    BUSINESS("Business"),
    FIRST("First");

    private final String travelClass;

    TravelClass(String travelClass) {
        this.travelClass = travelClass;
    }
}
