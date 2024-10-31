package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "common_user")
public class CommonUser {
  private String nome;
  private String email;
  private String senha;
  private Integer habitosDiarios;
  private Integer pegadaCarbono;
  private Integer medalhas;
  private String endereco;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Integer getHabitosDiarios() {
    return habitosDiarios;
  }

  public void setHabitosDiarios(Integer habitosDiarios) {
    this.habitosDiarios = habitosDiarios;
  }

  public Integer getPegadaCarbono() {
    return pegadaCarbono;
  }

  public void setPegadaCarbono(Integer pegadaCarbono) {
    this.pegadaCarbono = pegadaCarbono;
  }

  public Integer getMedalhas() {
    return medalhas;
  }

  public void setMedalhas(Integer medalhas) {
    this.medalhas = medalhas;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

}
