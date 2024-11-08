package com.fatec.cotia.projeto2.dsm2024.dtos.impactPanel;

import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateImpactPanelDTO {
  @Size(min = 0, max = 90)
  @NotNull
  private String impactoIndividual;
  @Size(min = 0, max = 90)
  @NotNull
  private String impactoColetivo;

  public CreateImpactPanelDTO() {

  }

  public CreateImpactPanelDTO(String impactoIndividual, String impactColetivo) {
    this.impactoColetivo = impactColetivo;
    this.impactoIndividual = impactoIndividual;
  }

  public CreateImpactPanelDTO(CreateImpactPanelDTO data) {
    this.impactoColetivo = data.getImpactoColetivo();
    this.impactoIndividual = data.getImpactoIndividual();
  }

  public CreateImpactPanelDTO(ImpactPanel data) {
    this.impactoColetivo = data.getImpactoColetivo();
    this.impactoIndividual = data.getImpactoIndividual();
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
