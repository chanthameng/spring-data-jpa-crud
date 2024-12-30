package com.kshrd.springdatajpacrud.exception.specificException;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
