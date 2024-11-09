package com.fatec.cotia.projeto2.dsm2024.dtos;

import com.fatec.cotia.projeto2.dsm2024.entities.Suggestion;
import com.fatec.cotia.projeto2.dsm2024.interfaces.CreationGroupInterface;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SuggestionDTO {
  @NotNull(groups = CreationGroupInterface.class)
  private Float reducaoCO2Estimado;
  @NotNull(groups = CreationGroupInterface.class)
  @Size(min = 11, max = 11)
  private String usuario_CPF;

  public SuggestionDTO() {

  }

  public SuggestionDTO(Float reducaoCO2Estimado, String usuario_CPF) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
    this.usuario_CPF = usuario_CPF;
  }

  public SuggestionDTO(SuggestionDTO data) {
    this.reducaoCO2Estimado = data.getReducaoCO2Estimado();
    this.usuario_CPF = data.getUsuario_CPF();
  }

  public SuggestionDTO(Suggestion data) {
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
