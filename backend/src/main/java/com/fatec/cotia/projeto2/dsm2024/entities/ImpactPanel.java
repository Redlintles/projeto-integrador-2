package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "impact_panel")
public class ImpactPanel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPainelDeImpacto;
  @Column(nullable = false)
  private Long UsuarioComum_idCPF;
  @Column(length = 90, nullable = false)
  private String impactoIndividual;
  @Column(length = 90, nullable = false)
  private String impactoColetivo;

  public String getImpactoColetivo() {
    return impactoColetivo;
  }

  public void setImpactoColetivo(String impactoColetivo) {
    this.impactoColetivo = impactoColetivo;
  }

  public String getImpactoIndividual() {
    return impactoIndividual;
  }

  public void setImpactoIndividual(String impactoIndividual) {
    this.impactoIndividual = impactoIndividual;
  }

  public Long getUsuarioComum_idCPF() {
    return UsuarioComum_idCPF;
  }

  public void setUsuarioComum_idCPF(Long UsuarioComum_idCPF) {
    this.UsuarioComum_idCPF = UsuarioComum_idCPF;
  }

  public Integer getIdPainelDeImpacto() {
    return idPainelDeImpacto;
  }

  public void setIdPainelDeImpacto(Integer idPainelDeImpacto) {
    this.idPainelDeImpacto = idPainelDeImpacto;
  }

}
