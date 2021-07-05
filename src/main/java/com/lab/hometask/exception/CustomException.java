package com.lab.hometask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException extends RuntimeException{

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String message) {
            super(message);
        }
    }

}