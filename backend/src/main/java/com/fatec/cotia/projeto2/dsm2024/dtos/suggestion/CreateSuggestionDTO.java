package com.fatec.cotia.projeto2.dsm2024.dtos.suggestion;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;

import jakarta.validation.constraints.NotNull;

public class CreateSuggestionDTO {
  @NotNull
  private Float reducaoCO2Estimado;
  @NotNull
  private CommonUser usuario_CPF;

  public CreateSuggestionDTO() {

  }

  public CreateSuggestionDTO(Float reducaoCO2Estimado, CommonUser usuario_CPF) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
    this.usuario_CPF = usuario_CPF;
  }

  public Float getReducaoCO2Estimado() {
    return reducaoCO2Estimado;
  }

  public void setReducaoCO2Estimado(Float reducaoCO2Estimado) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
  }

  public CommonUser getUsuario_CPF() {
    return usuario_CPF;
  }

  public void setUsuario_CPF(CommonUser usuario_CPF) {
    this.usuario_CPF = usuario_CPF;
  }

}
