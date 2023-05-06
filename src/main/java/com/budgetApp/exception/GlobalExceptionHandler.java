package com.budgetApp.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDTO> handle(ResponseStatusException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(ex.getReason());
        errorDTO.setTime(LocalDateTime.now().toString());

        return new ResponseEntity<>(errorDTO, ex.getStatusCode());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Data integrity violation: The requested operation could not be completed due to a constraint violation.");
        errorDTO.setTime(LocalDateTime.now().toString());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
