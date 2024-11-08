package com.fatec.cotia.projeto2.dsm2024.dtos.suggestion;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.Suggestion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateSuggestionDTO {
  @NotNull
  private Float reducaoCO2Estimado;
  @NotNull
  @Size(min = 11, max = 11)
  private String usuario_CPF;

  public CreateSuggestionDTO() {

  }

  public CreateSuggestionDTO(Float reducaoCO2Estimado, String usuario_CPF) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
    this.usuario_CPF = usuario_CPF;
  }

  public CreateSuggestionDTO(CreateSuggestionDTO data) {
    this.reducaoCO2Estimado = data.getReducaoCO2Estimado();
    this.usuario_CPF = data.getUsuario_CPF();
  }

  public CreateSuggestionDTO(Suggestion data) {
    this.reducaoCO2Estimado = data.getReducaoCO2Estimado();
    this.usuario_CPF = data.getUsuario_CPF().getCpf();
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
