package com.ndangduc.bn.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Validation;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ValidationExceptionHandler extends javax.validation.ValidationException {

    public ValidationExceptionHandler(String message) {
        super(message);
    }
}
