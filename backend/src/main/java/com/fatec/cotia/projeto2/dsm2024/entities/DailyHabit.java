package com.fatec.cotia.projeto2.dsm2024.entities;

import com.fatec.cotia.projeto2.dsm2024.dtos.DailyHabitDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_habit")
public class DailyHabit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cpf")
  private CommonUser Usuario_CPF;
  @Column(nullable = false)
  private Float usoEnergia;
  @Column(length = 45, nullable = false)
  private String alimentacao;
  @Column(length = 45, nullable = false)
  private String descarteLixo;
  @Column(nullable = false)
  private Long transporte;
  @Column(nullable = false)
  private Float calculoPegadaCarbono;

  public DailyHabit() {
  }

  public DailyHabit(
      CommonUser Usuario_CPF,
      Float usoEnergia,
      String alimentacao,
      String descarteLixo,
      Long transporte,
      Float calculoPegadaCarbono) {
    this.Usuario_CPF = Usuario_CPF;
    this.usoEnergia = usoEnergia;
    this.alimentacao = alimentacao;
    this.descarteLixo = descarteLixo;
    this.transporte = transporte;
    this.calculoPegadaCarbono = calculoPegadaCarbono;
  }

  public DailyHabit(DailyHabitDTO data) {
    this.Usuario_CPF = data.getUsuario_CPF();
    this.usoEnergia = data.getUsoEnergia();
    this.alimentacao = data.getAlimentacao();
    this.descarteLixo = data.getDescarteLixo();
    this.calculoPegadaCarbono = data.getCalculoPegadaCarbono();
    this.transporte = data.getTransporte();
  }

  public DailyHabit(DailyHabit data) {
    this.id = data.getId();
    this.Usuario_CPF = data.getUsuario_CPF();
    this.usoEnergia = data.getUsoEnergia();
    this.alimentacao = data.getAlimentacao();
    this.descarteLixo = data.getDescarteLixo();
    this.calculoPegadaCarbono = data.getCalculoPegadaCarbono();
    this.transporte = data.getTransporte();
  }

  public Float getUsoEnergia() {
    return usoEnergia;
  }

  public void setUsoEnergia(Float usoEnergia) {
    this.usoEnergia = usoEnergia;
  }

  public String getAlimentacao() {
    return alimentacao;
  }

  public void setAlimentacao(String alimentacao) {
    this.alimentacao = alimentacao;
  }

  public String getDescarteLixo() {
    return descarteLixo;
  }

  public void setDescarteLixo(String descarteLixo) {
    this.descarteLixo = descarteLixo;
  }

  public Long getTransporte() {
    return transporte;
  }

  public void setTransporte(Long transporte) {
    this.transporte = transporte;
  }

  public Float getCalculoPegadaCarbono() {
    return calculoPegadaCarbono;
  }

  public void setCalculoPegadaCarbono(Float calculoPegadaCarbono) {
    this.calculoPegadaCarbono = calculoPegadaCarbono;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CommonUser getUsuario_CPF() {
    return Usuario_CPF;
  }

  public void setUsuario_CPF(CommonUser Usuario_CPF) {
    this.Usuario_CPF = Usuario_CPF;
  }

}
