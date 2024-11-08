package com.fatec.cotia.projeto2.dsm2024.dtos.commonUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateCommonUserDTO {
  @NotNull
  private Long id;
  @Size(min = 11, max = 11)
  private String cpf;
  @Size(min = 11, max = 45)
  private String nome;
  @Size(min = 11, max = 45)
  private String senha;
  @Email
  @Size(min = 11, max = 45)
  private String email;
  @Size(min = 11, max = 90)
  private String endereco;
  private Long habitosDiarios;
  private Long medalhas;
  private Long pegadaCarbono;

  public UpdateCommonUserDTO() {
  }

  public UpdateCommonUserDTO(Long id, String cpf,
      String nome,
      String email,
      String senha,
      Long habitosDiarios,
      Long pegadaCarbono,
      Long medalhas,
      String endereco) {
    this.id = id;
    this.cpf = cpf;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.habitosDiarios = habitosDiarios;
    this.medalhas = medalhas;
    this.endereco = endereco;
    this.pegadaCarbono = pegadaCarbono;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Long getHabitosDiarios() {
    return habitosDiarios;
  }

  public void setHabitosDiarios(Long habitosDiarios) {
    this.habitosDiarios = habitosDiarios;
  }

  public Long getMedalhas() {
    return medalhas;
  }

  public void setMedalhas(Long medalhas) {
    this.medalhas = medalhas;
  }

  public Long getPegadaCarbono() {
    return pegadaCarbono;
  }

  public void setPegadaCarbono(Long pegadaCarbono) {
    this.pegadaCarbono = pegadaCarbono;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
