package com.hackaton.booking_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccommodationNotFoundException extends RuntimeException{
    public AccommodationNotFoundException(String message) {
        super(message);
    }
}
