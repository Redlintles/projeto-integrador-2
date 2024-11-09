package com.fatec.cotia.projeto2.dsm2024.dtos.suggestion;

import jakarta.validation.constraints.Size;

public class UpdateSuggestionDTO {
  private Float reducaoCO2Estimado;
  @Size(min = 11, max = 11)
  private String usuario_CPF;

  public UpdateSuggestionDTO() {
  }

  public UpdateSuggestionDTO(Float reducaoCO2Estimado, String usuario_CPF) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
    this.usuario_CPF = usuario_CPF;
  }

  public Float getReducaoCO2Estimado() {
    return reducaoCO2Estimado;
  }

  public void setReducaoCO2Estimado(Float reducaoCO2Estimado) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
  }

  public String getUsuario_CPF() {
    return usuario_CPF;
  }

  public void setUsuario_CPF(String usuario_CPF) {
    this.usuario_CPF = usuario_CPF;
  }

}
