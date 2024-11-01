package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medal")
public class Medal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMedalha;

  @Column(length = 45, nullable = false)
  private String nome;
  @Column(length = 45, nullable = false)
  private String descricao;
  @Column(length = 90, nullable = false)
  private String recompensa;

  @ManyToOne
  @JoinColumn(name = "idCNPJEmpresa")
  private CompanyUser usuarioEmpresa_idCNPJEmpresa;
  @ManyToOne
  @JoinColumn(name = "idCPF")
  private CommonUser usuarioComum_idCPF;

  public Integer getIdMedalha() {
    return idMedalha;
  }

  public void setIdMedalha(Integer idMedalha) {
    this.idMedalha = idMedalha;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getRecompensa() {
    return recompensa;
  }

  public void setRecompensa(String recompensa) {
    this.recompensa = recompensa;
  }

  public CompanyUser getUsuarioEmpresa_idCNPJEmpresa() {
    return usuarioEmpresa_idCNPJEmpresa;
  }

  public void setUsuarioEmpresa_idCNPJEmpresa(CompanyUser usuarioEmpresa_idCNPJEmpresa) {
    this.usuarioEmpresa_idCNPJEmpresa = usuarioEmpresa_idCNPJEmpresa;
  }

  public CommonUser getUsuarioComum_idCPF() {
    return usuarioComum_idCPF;
  }

  public void setUsuarioComum_idCPF(CommonUser usuarioComum_idCPF) {
    this.usuarioComum_idCPF = usuarioComum_idCPF;
  }

}
