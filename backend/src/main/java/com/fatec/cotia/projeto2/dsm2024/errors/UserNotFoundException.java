package com.fatec.cotia.projeto2.dsm2024.errors;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }

}
