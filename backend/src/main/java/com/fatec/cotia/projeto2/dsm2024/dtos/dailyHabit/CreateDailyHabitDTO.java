package com.fatec.cotia.projeto2.dsm2024.dtos.dailyHabit;

import jakarta.validation.constraints.NotNull;

public class CreateDailyHabitDTO {

  @NotNull
  private Float usoEnergia;
  @NotNull
  private String alimentacao;
  @NotNull
  private String descarteLixo;
  @NotNull
  private Long transporte;
  @NotNull
  private Float calculoPegadaCarbono;

  public CreateDailyHabitDTO() {

  }

  public CreateDailyHabitDTO(Float usoEnergia, String alimentacao, String descarteLixo, Long transporte,
      Float calculoPegadaCarbono) {
    this.usoEnergia = usoEnergia;
    this.alimentacao = alimentacao;
    this.descarteLixo = descarteLixo;
    this.calculoPegadaCarbono = calculoPegadaCarbono;
    this.transporte = transporte;

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
}
