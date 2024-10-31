package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_habit")
public class DailyHabit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer Funcionarios_UsuarioEmpresa_idCNPJEmpresa;
  private Integer Funcionarios_cpfFuncionario;
  private Integer UsuarioComum_idCPF;

  private Float usoEnergia;
  @Column(length = 45, nullable = false)
  private String alimentacao;
  @Column(length = 45, nullable = false)
  private String descarteLixo;
  private Integer transporte;
  private Float calculoPegadaCarbono;

  public Integer getFuncionarios_UsuarioEmpresa_idCNPJEmpresa() {
    return Funcionarios_UsuarioEmpresa_idCNPJEmpresa;
  }

  public void setFuncionarios_UsuarioEmpresa_idCNPJEmpresa(Integer Funcionarios_UsuarioEmpresa_idCNPJEmpresa) {
    this.Funcionarios_UsuarioEmpresa_idCNPJEmpresa = Funcionarios_UsuarioEmpresa_idCNPJEmpresa;
  }

  public Integer getFuncionarios_cpfFuncionario() {
    return Funcionarios_cpfFuncionario;
  }

  public void setFuncionarios_cpfFuncionario(Integer Funcionarios_cpfFuncionario) {
    this.Funcionarios_cpfFuncionario = Funcionarios_cpfFuncionario;
  }

  public Integer getUsuarioComum_idCPF() {
    return UsuarioComum_idCPF;
  }

  public void setUsuarioComum_idCPF(Integer UsuarioComum_idCPF) {
    this.UsuarioComum_idCPF = UsuarioComum_idCPF;
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

  public Integer getTransporte() {
    return transporte;
  }

  public void setTransporte(Integer transporte) {
    this.transporte = transporte;
  }

  public Float getCalculoPegadaCarbono() {
    return calculoPegadaCarbono;
  }

  public void setCalculoPegadaCarbono(Float calculoPegadaCarbono) {
    this.calculoPegadaCarbono = calculoPegadaCarbono;
  }

}
