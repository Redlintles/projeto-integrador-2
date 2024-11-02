package com.fatec.cotia.projeto2.dsm2024.dtos.impactPanel;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;

import jakarta.validation.constraints.NotNull;

public class UpdateImpactPanelDTO {
  @NotNull
  private Long id;
  private CommonUser Usuario_cpf;
  private String impactoIndividual;
  private String impactoColetivo;

  public UpdateImpactPanelDTO() {
  }

  public UpdateImpactPanelDTO(Long id, CommonUser Usuario_cpf, String impactoIndividual, String impactoColetivo) {
    this.id = id;
    this.Usuario_cpf = Usuario_cpf;
    this.impactoColetivo = impactoColetivo;
    this.impactoIndividual = impactoIndividual;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
