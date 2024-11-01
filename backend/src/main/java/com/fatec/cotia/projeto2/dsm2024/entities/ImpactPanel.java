package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "impact_panel")
public class ImpactPanel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idPainelDeImpacto;
  @OneToOne
  @JoinColumn(name = "cpf")
  private CommonUser Usuario_cpf;
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

  public Long getIdPainelDeImpacto() {
    return idPainelDeImpacto;
  }

  public void setIdPainelDeImpacto(Long idPainelDeImpacto) {
    this.idPainelDeImpacto = idPainelDeImpacto;
  }

  public CommonUser getUsuario_cpf() {
    return Usuario_cpf;
  }

  public void setUsuario_cpf(CommonUser Usuario_cpf) {
    this.Usuario_cpf = Usuario_cpf;
  }

}
