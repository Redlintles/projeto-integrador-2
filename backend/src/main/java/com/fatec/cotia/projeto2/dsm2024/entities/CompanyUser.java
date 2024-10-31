package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_user")
public class CompanyUser {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Integer idCNPJEmpresa;
  @Column(length = 45, nullable = false)
  private String nomeEmpresa;
  @Column(length = 45, nullable = false)
  private String emailEmpresa;
  @Column(length = 45, nullable = false)
  private String senha;
  @Column(length = 45, nullable = false)
  private String certificacoes;
  private Integer habitosEmpresa;
  private Integer pegadaCarbonoEmpresa;
  private Integer medalhas;
  @Column(length = 90, nullable = false)
  private String endereco;

  public Integer getIdCNPJEmpresa() {
    return idCNPJEmpresa;
  }

  public void setIdCNPJEmpresa(Integer idCNPJEmpresa) {
    this.idCNPJEmpresa = idCNPJEmpresa;
  }

  public String getEmailEmpresa() {
    return emailEmpresa;
  }

  public void setEmailEmpresa(String emailEmpresa) {
    this.emailEmpresa = emailEmpresa;
  }

  public String getNomeEmpresa() {
    return nomeEmpresa;
  }

  public void setNomeEmpresa(String nomeEmpresa) {
    this.nomeEmpresa = nomeEmpresa;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getCertificacoes() {
    return certificacoes;
  }

  public void setCertificacoes(String certificacoes) {
    this.certificacoes = certificacoes;
  }

  public Integer getHabitosEmpresa() {
    return habitosEmpresa;
  }

  public void setHabitosEmpresa(Integer habitosEmpresa) {
    this.habitosEmpresa = habitosEmpresa;
  }

  public Integer getPegadaCarbonoEmpresa() {
    return pegadaCarbonoEmpresa;
  }

  public void setPegadaCarbonoEmpresa(Integer pegadaCarbonoEmpresa) {
    this.pegadaCarbonoEmpresa = pegadaCarbonoEmpresa;
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
}
