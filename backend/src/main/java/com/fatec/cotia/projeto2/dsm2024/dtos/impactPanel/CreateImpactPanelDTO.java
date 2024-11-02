package com.fatec.cotia.projeto2.dsm2024.dtos.impactPanel;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;

public class CreateImpactPanelDTO {
  private CommonUser Usuario_cpf;
  private String impactoIndividual;
  private String impactoColetivo;

  public CreateImpactPanelDTO() {

  }

  public CreateImpactPanelDTO(CommonUser Usuario_cpf, String impactoIndividual, String impactColetivo) {
    this.Usuario_cpf = Usuario_cpf;
    this.impactoColetivo = impactColetivo;
    this.impactoIndividual = impactoIndividual;
  }

  public CommonUser getUsuario_cpf() {
    return Usuario_cpf;
  }

  public void setUsuario_cpf(CommonUser Usuario_cpf) {
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
