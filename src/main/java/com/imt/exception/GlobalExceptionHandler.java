package com.imt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientException.class)
    public String handleClientNotFoundException(ClientException ex) {
    	return ex.getMessage();
    }

    @ExceptionHandler(InsurancePolicyException.class)
    public ResponseEntity<Object> handleInsurancePolicyNotFoundException(
    		InsurancePolicyException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClaimException.class)
    public ResponseEntity<Object> handleClaimNotFoundException(
    		ClaimException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
}
