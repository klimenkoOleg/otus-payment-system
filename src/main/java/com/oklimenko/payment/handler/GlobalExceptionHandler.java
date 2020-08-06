package com.oklimenko.payment.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oklimenko.payment.dto.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@AllArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    private ObjectMapper objectMapper;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> handleException(Exception ex) {
        log.error("An unknown error occurred.", ex);
        return new ResponseEntity<>(Result.error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}