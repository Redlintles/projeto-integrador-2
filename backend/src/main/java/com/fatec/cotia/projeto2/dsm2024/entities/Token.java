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

  @Column(nullable = false, unique = true)
  private String cpf;

  @Column(nullable = false, unique = true)
  private String token;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  public Token() {

  }

  public Token(Token data) {
    this.createdAt = data.getCreatedAt();
    this.token = data.getToken();
    this.cpf = data.getCpf();
  }

  public Token(TokenDTO data) {
    this.createdAt = data.getCreatedAt();
    this.token = data.getToken();
    this.cpf = data.getCpf();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
