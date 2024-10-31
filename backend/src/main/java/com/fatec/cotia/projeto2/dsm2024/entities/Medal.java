package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medal")
public class Medal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMedalha;
  private Integer UsuarioEmpresa_idCNPJEmpresa;
  private Integer UsuarioComum_idCPF;

  @Column(length = 45, nullable = false)
  private String nome;
  @Column(length = 45, nullable = false)
  private String descricao;
  @Column(length = 90, nullable = false)
  private String recompensa;

  public Integer getIdMedalha() {
    return idMedalha;
  }

  public void setIdMedalha(Integer idMedalha) {
    this.idMedalha = idMedalha;
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

}
