package com.ndangduc.bn.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ErrorSaveException extends RuntimeException {
    public ErrorSaveException(String message) {
        super(message);
    }
}
