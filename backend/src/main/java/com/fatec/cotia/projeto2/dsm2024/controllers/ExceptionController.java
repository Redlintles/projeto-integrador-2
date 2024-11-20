package com.fatec.cotia.projeto2.dsm2024.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeCreatedException;
import com.fatec.cotia.projeto2.dsm2024.errors.TokenAlreadyExistsException;
import com.fatec.cotia.projeto2.dsm2024.errors.UserNotFoundException;
import com.fatec.cotia.projeto2.dsm2024.responses.ErrorResponse;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {
    ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(TokenAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleTokenAlreadyExists(TokenAlreadyExistsException ex) {
    ErrorResponse response = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());

    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(EntityCouldNotBeCreatedException.class)
  public ResponseEntity<ErrorResponse> handleEntityCouldNotBeCreated(EntityCouldNotBeCreatedException ex) {
    ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

}
