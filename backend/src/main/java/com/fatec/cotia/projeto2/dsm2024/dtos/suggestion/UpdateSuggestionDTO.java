package com.fatec.cotia.projeto2.dsm2024.dtos.suggestion;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;

import jakarta.validation.constraints.NotNull;

public class UpdateSuggestionDTO {
  @NotNull
  private Long id;

  private Float reducaoCO2Estimado;
  private CommonUser usuario_CPF;

  public UpdateSuggestionDTO() {
  }

  public UpdateSuggestionDTO(Long id, Float reducaoCO2Estimado, CommonUser usuario_CPF) {
    this.id = id;
    this.reducaoCO2Estimado = reducaoCO2Estimado;
    this.usuario_CPF = usuario_CPF;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
