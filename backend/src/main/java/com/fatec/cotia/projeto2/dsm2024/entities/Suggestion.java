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
  private Long idSugestao;
  private Float reducaoCO2Estimado;

  @ManyToOne()
  @JoinColumn(name = "idCPF")
  private CommonUser usuarioComum_idCPF;

  public Long getIdSugestao() {
    return idSugestao;
  }

  public void setIdSugestao(Long idSugestao) {
    this.idSugestao = idSugestao;
  }

  public Float getReducaoCO2Estimado() {
    return reducaoCO2Estimado;
  }

  public void setReducaoCO2Estimado(Float reducaoCO2Estimado) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
  }

  public CommonUser getUsuarioComum_idCPF() {
    return usuarioComum_idCPF;
  }

  public void setUsuarioComum_idCPF(CommonUser usuarioComum_idCPF) {
    this.usuarioComum_idCPF = usuarioComum_idCPF;
  }

}
