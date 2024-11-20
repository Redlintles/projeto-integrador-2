package com.fatec.cotia.projeto2.dsm2024.errors;

public class TokenAlreadyExistsException extends RuntimeException {
  public TokenAlreadyExistsException(String message) {
    super(message);
  }
}
