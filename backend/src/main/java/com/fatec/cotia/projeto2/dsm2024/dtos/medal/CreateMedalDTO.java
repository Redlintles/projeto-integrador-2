package com.fatec.cotia.projeto2.dsm2024.dtos.medal;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.Medal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateMedalDTO {
  @NotNull
  @Size(min = 0, max = 45)
  private String nome;
  @NotNull
  @Size(min = 0, max = 45)
  private String descricao;
  @NotNull
  @Size(min = 0, max = 90)
  private String recompensa;
  @NotNull
  @Size(min = 11, max = 11)
  private CommonUser usuario_CPF;

  public CreateMedalDTO() {

  }

  public CreateMedalDTO(String nome, String descricao, String recompensa, CommonUser usuario_CPF) {
    this.nome = nome;
    this.descricao = descricao;
    this.recompensa = recompensa;
    this.usuario_CPF = usuario_CPF;
  }

  public CreateMedalDTO(CreateMedalDTO data) {
    this.nome = data.getNome();
    this.descricao = data.getDescricao();
    this.recompensa = data.getRecompensa();
    this.usuario_CPF = data.getUsuario_CPF();
  }

  public CreateMedalDTO(Medal data) {
    this.nome = data.getNome();
    this.descricao = data.getDescricao();
    this.recompensa = data.getRecompensa();
    this.usuario_CPF = data.getUsuario_CPF();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getRecompensa() {
    return recompensa;
  }

  public void setRecompensa(String recompensa) {
    this.recompensa = recompensa;
  }

  public CommonUser getUsuario_CPF() {
    return usuario_CPF;
  }

  public void setUsuario_CPF(CommonUser usuario_CPF) {
    this.usuario_CPF = usuario_CPF;
  }

}
