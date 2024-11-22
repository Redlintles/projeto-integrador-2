package com.fatec.cotia.projeto2.dsm2024.responses;

import java.time.LocalDateTime;

public class StandardResponse<T> {
  private final T data;
  private final String message;
  private final LocalDateTime requestedAt;

  public StandardResponse(T data, String message) {
    this.requestedAt = LocalDateTime.now();
    this.data = data;
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public String getMessage() {
    return message;
  }

  public LocalDateTime getRequestedAt() {
    return requestedAt;
  }
}
