package com.fatec.cotia.projeto2.dsm2024.responses;

import java.time.LocalDateTime;

public class ErrorResponse {

  private final int status;

  private final String message;

  private final LocalDateTime timestamp;

  public ErrorResponse(int status, String message) {
    this.status = status;
    this.message = message;
    this.timestamp = LocalDateTime.now();
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

}
