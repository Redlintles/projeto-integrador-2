package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

  @OneToOne
  @JoinColumn(name = "idPainelDeImpacto")
  private ImpactPanel IdPainelDeImpacto;

  @OneToOne
  @JoinColumn(name = "UsuarioEmpresa_idCNPJEmpresa")
  private ImpactPanel UsuarioEmpresa_idCNPJEmpresa;

  @OneToOne
  @JoinColumn(name = "UsuarioComum_idCPF")
  private ImpactPanel UsuarioComum_idCPF;

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

  public ImpactPanel getIdPainelDeImpacto() {
    return IdPainelDeImpacto;
  }

  public void setIdPainelDeImpacto(ImpactPanel IdPainelDeImpacto) {
    this.IdPainelDeImpacto = IdPainelDeImpacto;
  }

  public ImpactPanel getUsuarioEmpresa_idCNPJEmpresa() {
    return UsuarioEmpresa_idCNPJEmpresa;
  }

  public void setUsuarioEmpresa_idCNPJEmpresa(ImpactPanel UsuarioEmpresa_idCNPJEmpresa) {
    this.UsuarioEmpresa_idCNPJEmpresa = UsuarioEmpresa_idCNPJEmpresa;
  }

  public ImpactPanel getUsuarioComum_idCPF() {
    return UsuarioComum_idCPF;
  }

  public void setUsuarioComum_idCPF(ImpactPanel UsuarioComum_idCPF) {
    this.UsuarioComum_idCPF = UsuarioComum_idCPF;
  }
}
