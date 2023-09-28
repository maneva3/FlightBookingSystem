package com.flightbookingsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonalInfoNotFoundException extends RuntimeException {
    public PersonalInfoNotFoundException(String message) {
        super(message);
    }
}
