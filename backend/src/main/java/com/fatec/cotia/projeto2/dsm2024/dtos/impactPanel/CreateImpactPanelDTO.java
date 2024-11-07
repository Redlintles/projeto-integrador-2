package com.fatec.cotia.projeto2.dsm2024.dtos.impactPanel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateImpactPanelDTO {
  @NotNull
  @Size(min = 11, max = 11)
  private String Usuario_cpf;
  @Size(min = 0, max = 90)
  @NotNull
  private String impactoIndividual;
  @Size(min = 0, max = 90)
  @NotNull
  private String impactoColetivo;

  public CreateImpactPanelDTO() {

  }

  public CreateImpactPanelDTO(String Usuario_cpf, String impactoIndividual, String impactColetivo) {
    this.Usuario_cpf = Usuario_cpf;
    this.impactoColetivo = impactColetivo;
    this.impactoIndividual = impactoIndividual;
  }

  public String getUsuario_cpf() {
    return Usuario_cpf;
  }

  public void setUsuario_cpf(String Usuario_cpf) {
    this.Usuario_cpf = Usuario_cpf;
  }

  public String getImpactoIndividual() {
    return impactoIndividual;
  }

  public void setImpactoIndividual(String impactoIndividual) {
    this.impactoIndividual = impactoIndividual;
  }

  public String getImpactoColetivo() {
    return impactoColetivo;
  }

  public void setImpactoColetivo(String impactoColetivo) {
    this.impactoColetivo = impactoColetivo;
  }
}
