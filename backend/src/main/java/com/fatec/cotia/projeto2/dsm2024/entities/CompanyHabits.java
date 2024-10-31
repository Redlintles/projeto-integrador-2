package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitos_empresa")
public class CompanyHabits {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer UsuarioEmpresa_idCNPJEmpresa;
  private Float consumoEnergia;
  @Column(length = 0x5a, nullable = false)
  private String praticasReciclagem;
  @Column(length = 45, nullable = false)
  private String transporteColetivo;
  private Float calcularImpactoEmpresa;

  public Integer getUsuarioEmpresa_idCNPJEmpresa() {
    return UsuarioEmpresa_idCNPJEmpresa;
  }

  public void setUsuarioEmpresa_idCNPJEmpresa(Integer UsuarioEmpresa_idCNPJEmpresa) {
    this.UsuarioEmpresa_idCNPJEmpresa = UsuarioEmpresa_idCNPJEmpresa;
  }

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

}
