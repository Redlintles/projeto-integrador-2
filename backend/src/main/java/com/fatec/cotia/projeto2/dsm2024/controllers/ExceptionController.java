package com.fatec.cotia.projeto2.dsm2024.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fatec.cotia.projeto2.dsm2024.errors.UserNotFoundException;
import com.fatec.cotia.projeto2.dsm2024.responses.ErrorResponse;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {
    ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

}
