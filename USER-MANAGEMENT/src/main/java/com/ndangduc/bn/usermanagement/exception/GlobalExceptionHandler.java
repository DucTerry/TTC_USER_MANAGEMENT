package com.ndangduc.bn.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity<?> hanlderDuplicatedException(DuplicatedException ex, WebRequest request){
        ErrrorResponse errrorResponse = new ErrrorResponse(HttpStatus.CONFLICT, ex.getMessage());

        return new ResponseEntity<>(errrorResponse,HttpStatus.CONFLICT);
    }
}
