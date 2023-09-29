package com.flightbookingsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdentificationDocumentNotFoundException extends RuntimeException {
    public IdentificationDocumentNotFoundException(String message) {
        super(message);
    }
}

