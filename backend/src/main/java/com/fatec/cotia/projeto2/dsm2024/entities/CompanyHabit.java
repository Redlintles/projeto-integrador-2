package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habito_empresa")
public class CompanyHabit {
  @Id
  @ManyToOne
  @JoinColumn(name = "idCNPJEmpresa")
  private CompanyUser usuarioEmpresa_idCNPJEmpresa;

  private Float consumoEnergia;
  @Column(length = 0x5a, nullable = false)
  private String praticasReciclagem;
  @Column(length = 45, nullable = false)
  private String transporteColetivo;
  private Float calcularImpactoEmpresa;

  public Float getConsumoEnergia() {
    return consumoEnergia;
  }

  public void setConsumoEnergia(Float consumoEnergia) {
    this.consumoEnergia = consumoEnergia;
  }

  public String getPraticasReciclagem() {
    return praticasReciclagem;
  }

  public void setPraticasReciclagem(String praticasReciclagem) {
    this.praticasReciclagem = praticasReciclagem;
  }

  public String getTransporteColetivo() {
    return transporteColetivo;
  }

  public void setTransporteColetivo(String transporteColetivo) {
    this.transporteColetivo = transporteColetivo;
  }

  public Float getCalcularImpactoEmpresa() {
    return calcularImpactoEmpresa;
  }

  public void setCalcularImpactoEmpresa(Float calcularImpactoEmpresa) {
    this.calcularImpactoEmpresa = calcularImpactoEmpresa;
  }

  public CompanyUser getUsuarioEmpresa_idCNPJEmpresa() {
    return usuarioEmpresa_idCNPJEmpresa;
  }

  public void setUsuarioEmpresa_idCNPJEmpresa(CompanyUser usuarioEmpresa_idCNPJEmpresa) {
    this.usuarioEmpresa_idCNPJEmpresa = usuarioEmpresa_idCNPJEmpresa;
  }

}
