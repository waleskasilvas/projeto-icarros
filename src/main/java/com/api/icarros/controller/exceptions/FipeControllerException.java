package com.api.icarros.controller.exceptions;

import com.api.icarros.domain.StandardError;
import com.api.icarros.domain.exceptions.InternalErrorException;
import com.api.icarros.domain.exceptions.ObjectException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class FipeControllerException {

    @ExceptionHandler(ObjectException.class)
    public ResponseEntity<StandardError> feign(ObjectException e, HttpServletRequest request) {
        return ResponseEntity.status(e.status()).body(new StandardError(LocalDateTime.now(),
                e.status(),
                e.getMessage(),
                request.getRequestURI()));
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<StandardError> internalError(InternalErrorException e, HttpServletRequest request) {
        HttpStatus status= HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(new StandardError(LocalDateTime.now(),status.value(), e.getMessage(), request.getRequestURI()));
    }
}
