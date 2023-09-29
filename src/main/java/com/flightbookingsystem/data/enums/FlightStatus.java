package com.flightbookingsystem.data.enums;

import lombok.Getter;

@Getter
public enum FlightStatus {
    SCHEDULED("Scheduled"),
    DEPARTED("Departed"),
    LANDED("Landed"),
    CANCELLED("Cancelled");

    private final String flightStatus;

    FlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }
}
