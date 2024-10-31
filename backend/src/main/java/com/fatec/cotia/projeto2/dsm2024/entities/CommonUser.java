package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "common_user")
public class CommonUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCPF;

  private String nome;
  private String email;
  private String senha;
  private Integer habitosDiarios;
  private Integer pegadaCarbono;
  private Integer medalhas;
  private String endereco;

  @OneToOne
  @JoinColumn(name = "idPainelDeImpacto")
  private Integer idPainelDeImpacto;
  @OneToOne
  @JoinColumn(name = "UsuarioEmpresa_idCNPJEmpresa")
  private Integer UsuarioEmpresa_idCNPJEmpresa;
  @OneToOne
  @JoinColumn(name = "UsuarioComum_idCPF")
  private Integer UsuarioComum_idCPF;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public Integer getMedalhas() {
    return medalhas;
  }

  public void setMedalhas(Integer medalhas) {
    this.medalhas = medalhas;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Integer getCpf() {
    return idCPF;
  }

  public void setCpf(Integer cpf) {
    this.idCPF = cpf;
  }

  public Integer getIdPainelDeImpacto() {
    return idPainelDeImpacto;
  }

  public void setIdPainelDeImpacto(Integer idPainelDeImpacto) {
    this.idPainelDeImpacto = idPainelDeImpacto;
  }

  public Integer getUsuarioEmpresa_idCNPJEmpresa() {
    return UsuarioEmpresa_idCNPJEmpresa;
  }

  public void setUsuarioEmpresa_idCNPJEmpresa(Integer UsuarioEmpresa_idCNPJEmpresa) {
    this.UsuarioEmpresa_idCNPJEmpresa = UsuarioEmpresa_idCNPJEmpresa;
  }

  public Integer getUsuarioComum_idCPF() {
    return UsuarioComum_idCPF;
  }

  public void setUsuarioComum_idCPF(Integer UsuarioComum_idCPF) {
    this.UsuarioComum_idCPF = UsuarioComum_idCPF;
  }

}
