package com.fatec.cotia.projeto2.dsm2024.dtos.dailyHabit;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateDailyHabitDTO {
  @NotNull
  @Size(min = 11, max = 11)
  private CommonUser Usuario_CPF;

  @NotNull
  private Float usoEnergia;
  @NotNull
  @Size(min = 0, max = 45)
  private String alimentacao;
  @NotNull
  @Size(min = 0, max = 45)
  private String descarteLixo;
  @NotNull
  private Long transporte;
  @NotNull
  private Float calculoPegadaCarbono;

  public CreateDailyHabitDTO() {

  }

  public CreateDailyHabitDTO(Float usoEnergia, String alimentacao, String descarteLixo, Long transporte,
      Float calculoPegadaCarbono, CommonUser Usuario_CPF) {
    this.Usuario_CPF = Usuario_CPF;
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

  public CommonUser getUsuario_CPF() {
    return Usuario_CPF;
  }

  public void setUsuario_CPF(CommonUser Usuario_CPF) {
    this.Usuario_CPF = Usuario_CPF;
  }
}
