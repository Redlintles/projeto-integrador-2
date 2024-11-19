package com.fatec.cotia.projeto2.dsm2024.entities;

import java.time.LocalDateTime;

import com.fatec.cotia.projeto2.dsm2024.dtos.TokenDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "token")
public class Token {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne
  @JoinColumn(name = "cpf")
  private CommonUser Usuario_CPF;

  @Column(nullable = false, unique = true)
  private String token;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  public Token() {

  }

  public Token(Token data) {
    this.createdAt = data.getCreatedAt();
    this.token = data.getToken();
    this.Usuario_CPF = data.getUsuario_CPF();
  }

  public Token(TokenDTO data) {
    this.createdAt = data.getCreatedAt();
    this.token = data.getToken();
    this.Usuario_CPF = data.getUsuario_CPF();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
