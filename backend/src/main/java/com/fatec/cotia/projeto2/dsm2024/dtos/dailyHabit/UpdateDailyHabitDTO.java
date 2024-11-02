package com.fatec.cotia.projeto2.dsm2024.dtos.dailyHabit;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateDailyHabitDTO {
  @NotNull
  private Long id;
  private Float usoEnergia;
  @Size(min = 0, max = 45)
  private String alimentacao;
  @Size(min = 0, max = 45)
  private String descarteLixo;
  private Long transporte;
  private Float calculoPegadaCarbono;

  public UpdateDailyHabitDTO() {
  }

  public UpdateDailyHabitDTO(Long id, Float usoEnergia, String alimentacao, String descarteLixo, Long transporte,
      Float calculoPegadaCarbono) {
    this.id = id;
    this.usoEnergia = usoEnergia;
    this.alimentacao = alimentacao;
    this.calculoPegadaCarbono = calculoPegadaCarbono;
    this.descarteLixo = descarteLixo;
    this.transporte = transporte;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
