package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_habit")
public class DailyHabit {
  @Id
  @OneToOne
  @JoinColumn(name = "idCNPJEmpresa")
  private CompanyUser Funcionarios_UsuarioEmpresa_idCNPJEmpresa;
  @ManyToOne
  @JoinColumn(name = "idCPF")
  private CommonUser UsuarioComum_idCPF;
  @ManyToOne
  @JoinColumn(name = "cpfFuncionario")
  private CommonUser Funcionarios_cpfFuncionario;

  private Float usoEnergia;
  @Column(length = 45, nullable = false)
  private String alimentacao;
  @Column(length = 45, nullable = false)
  private String descarteLixo;
  private Integer transporte;
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

  public CompanyUser getFuncionarios_UsuarioEmpresa_idCNPJEmpresa() {
    return Funcionarios_UsuarioEmpresa_idCNPJEmpresa;
  }

  public void setFuncionarios_UsuarioEmpresa_idCNPJEmpresa(CompanyUser Funcionarios_UsuarioEmpresa_idCNPJEmpresa) {
    this.Funcionarios_UsuarioEmpresa_idCNPJEmpresa = Funcionarios_UsuarioEmpresa_idCNPJEmpresa;
  }

  public CommonUser getFuncionarios_cpfFuncionario() {
    return Funcionarios_cpfFuncionario;
  }

  public void setFuncionarios_cpfFuncionario(CommonUser Funcionarios_cpfFuncionario) {
    this.Funcionarios_cpfFuncionario = Funcionarios_cpfFuncionario;
  }

  public CommonUser getUsuarioComum_idCPF() {
    return UsuarioComum_idCPF;
  }

  public void setUsuarioComum_idCPF(CommonUser UsuarioComum_idCPF) {
    this.UsuarioComum_idCPF = UsuarioComum_idCPF;
  }

}
