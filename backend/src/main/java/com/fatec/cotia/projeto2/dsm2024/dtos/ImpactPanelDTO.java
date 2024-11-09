package com.fatec.cotia.projeto2.dsm2024.dtos;

import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.interfaces.CreationGroupInterface;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ImpactPanelDTO {
  @Size(min = 0, max = 90)
  @NotNull(groups = CreationGroupInterface.class)
  private String impactoIndividual;
  @Size(min = 0, max = 90)
  @NotNull(groups = CreationGroupInterface.class)
  private String impactoColetivo;

  public ImpactPanelDTO() {

  }

  public ImpactPanelDTO(String impactoIndividual, String impactColetivo) {
    this.impactoColetivo = impactColetivo;
    this.impactoIndividual = impactoIndividual;
  }

  public ImpactPanelDTO(ImpactPanelDTO data) {
    this.impactoColetivo = data.getImpactoColetivo();
    this.impactoIndividual = data.getImpactoIndividual();
  }

  public ImpactPanelDTO(ImpactPanel data) {
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
