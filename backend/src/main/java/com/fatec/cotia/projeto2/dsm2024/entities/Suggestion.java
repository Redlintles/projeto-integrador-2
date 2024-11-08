package com.fatec.cotia.projeto2.dsm2024.entities;

import com.fatec.cotia.projeto2.dsm2024.dtos.suggestion.CreateSuggestionDTO;

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
  private Long id;
  private Float reducaoCO2Estimado;

  @ManyToOne()
  @JoinColumn(name = "cpf")
  private CommonUser usuario_CPF;

  public Suggestion() {

  }

  public Suggestion(Float reducaoCO2Estimado, CommonUser usuario_CPF) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
    this.usuario_CPF = usuario_CPF;
  }

  public Suggestion(Suggestion data) {
    this.reducaoCO2Estimado = data.getReducaoCO2Estimado();
    this.usuario_CPF = data.getUsuario_CPF();
  }

  public Suggestion(CreateSuggestionDTO data) {
    this.reducaoCO2Estimado = data.getReducaoCO2Estimado();
    this.usuario_CPF = data.getUsuario_CPF();
  }

  public Float getReducaoCO2Estimado() {
    return reducaoCO2Estimado;
  }

  public void setReducaoCO2Estimado(Float reducaoCO2Estimado) {
    this.reducaoCO2Estimado = reducaoCO2Estimado;
  }

  public CommonUser getUsuario_CPF() {
    return usuario_CPF;
  }

  public void setUsuario_CPF(CommonUser usuario_CPF) {
    this.usuario_CPF = usuario_CPF;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
