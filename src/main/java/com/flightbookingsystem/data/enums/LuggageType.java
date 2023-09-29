package com.flightbookingsystem.data.enums;

import lombok.Getter;

@Getter
public enum LuggageType {
    FREE("Free"),
    CABIN("Cabin"),
    CHECKED_AND_CABIN("Checked and Cabin");

    private final String luggageType;

    LuggageType(String luggageType) {
        this.luggageType = luggageType;
    }
}
