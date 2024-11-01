package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "suggestion")
public class Suggestion {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Integer idSugestao;
  private Integer UsuarioComum_idCPF;
  private Float reducaoCO2Estimado;

  @ManyToOne()
  @JoinColumn(name = "idCPF")
  private CommonUser usuarioComum_idCPF;

  public Integer getIdSugestao() {
    return idSugestao;
  }

  public void setIdSugestao(Integer idSugestao) {
    this.idSugestao = idSugestao;
  }

  public Integer getUsuarioComum_idCPF() {
    return UsuarioComum_idCPF;
  }

  public void setUsuarioComum_idCPF(Integer UsuarioComum_idCPF) {
    this.UsuarioComum_idCPF = UsuarioComum_idCPF;
  }

  public Float getReducaoCO2Estimado() {
    return reducaoCO2Estimado;
  }

  public void setReducaoCO2Estimado(Float reducaoCO2Estimado) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
  }

}
