package com.fatec.cotia.projeto2.dsm2024.dtos;

import java.time.LocalDateTime;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.Token;

public class TokenDTO {
  private CommonUser Usuario_CPF;
  private String token;
  private LocalDateTime createdAt;

  public TokenDTO() {

  }

  public TokenDTO(Token data) {
    this.createdAt = data.getCreatedAt();
    this.token = data.getToken();
    this.Usuario_CPF = data.getUsuario_CPF();
  }

  public TokenDTO(TokenDTO data) {
    this.createdAt = data.getCreatedAt();
    this.token = data.getToken();
    this.Usuario_CPF = data.getUsuario_CPF();
  }

  public CommonUser getUsuario_CPF() {
    return Usuario_CPF;
  }

  public void setUsuario_CPF(CommonUser Usuario_CPF) {
    this.Usuario_CPF = Usuario_CPF;
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
