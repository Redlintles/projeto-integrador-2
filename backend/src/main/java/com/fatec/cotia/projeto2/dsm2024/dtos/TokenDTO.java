package com.fatec.cotia.projeto2.dsm2024.dtos;

import java.time.LocalDateTime;

import com.fatec.cotia.projeto2.dsm2024.entities.Token;

public class TokenDTO {
  private String cpf;
  private String token;
  private LocalDateTime createdAt;

  public TokenDTO() {

  }

  public TokenDTO(Token data) {
    this.createdAt = data.getCreatedAt();
    this.token = data.getToken();
    this.cpf = data.getCpf();
  }

  public TokenDTO(TokenDTO data) {
    this.createdAt = data.getCreatedAt();
    this.token = data.getToken();
    this.cpf = data.getCpf();
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

}
