package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer cpfFuncionario;
  private Integer UsuarioEmpresa_idCNPJEmpresa;
  private String nome;
  private String senha;
  private Integer habitosDiarios;
  private Integer pegadaCarbono;
  private String endereco;

  public Integer getCpfFuncionario() {
    return cpfFuncionario;
  }

  public void setCpfFuncionario(Integer cpfFuncionario) {
    this.cpfFuncionario = cpfFuncionario;
  }

  public Integer getUsuarioEmpresa_idCNPJEmpresa() {
    return UsuarioEmpresa_idCNPJEmpresa;
  }

  public void setUsuarioEmpresa_idCNPJEmpresa(Integer UsuarioEmpresa_idCNPJEmpresa) {
    this.UsuarioEmpresa_idCNPJEmpresa = UsuarioEmpresa_idCNPJEmpresa;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Integer getHabitosDiarios() {
    return habitosDiarios;
  }

  public void setHabitosDiarios(Integer habitosDiarios) {
    this.habitosDiarios = habitosDiarios;
  }

  public Integer getPegadaCarbono() {
    return pegadaCarbono;
  }

  public void setPegadaCarbono(Integer pegadaCarbono) {
    this.pegadaCarbono = pegadaCarbono;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
}
