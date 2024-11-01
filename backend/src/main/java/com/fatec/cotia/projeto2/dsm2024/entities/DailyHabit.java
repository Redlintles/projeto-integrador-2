package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_habit")
public class DailyHabit {

  @Id
  @ManyToOne
  @JoinColumn(name = "idCPF")
  private CommonUser Usuario_idCPF;
  @ManyToOne
  @JoinColumn(name = "cpfFuncionario")
  private CommonUser Funcionarios_cpfFuncionario;
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

  public CommonUser getFuncionarios_cpfFuncionario() {
    return Funcionarios_cpfFuncionario;
  }

  public void setFuncionarios_cpfFuncionario(CommonUser Funcionarios_cpfFuncionario) {
    this.Funcionarios_cpfFuncionario = Funcionarios_cpfFuncionario;
  }

  public CommonUser getUsuario_idCPF() {
    return Usuario_idCPF;
  }

  public void setUsuario_idCPF(CommonUser Usuario_idCPF) {
    this.Usuario_idCPF = Usuario_idCPF;
  }

}
