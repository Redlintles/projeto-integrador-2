package com.fatec.cotia.projeto2.dsm2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "common_user")
public class CommonUser {
  @Id
  @Column(nullable = false)
  private Long idCPF;

  @Column(length = 45, nullable = false)
  private String nome;
  @Column(length = 45, nullable = false)
  private String email;
  @Column(length = 45, nullable = false)
  private String senha;

  @Column(nullable = false)
  private Long habitosDiarios;
  @Column(nullable = false)
  private Long pegadaCarbono;
  @Column(nullable = false)
  private Long medalhas;
  @Column(length = 90, nullable = false)
  private String endereco;

  @OneToOne
  @JoinColumn(name = "idPainelDeImpacto")
  private ImpactPanel idPainelDeImpacto;

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

  public Long getHabitosDiarios() {
    return habitosDiarios;
  }

  public void setHabitosDiarios(Long habitosDiarios) {
    this.habitosDiarios = habitosDiarios;
  }

  public Long getPegadaCarbono() {
    return pegadaCarbono;
  }

  public void setPegadaCarbono(Long pegadaCarbono) {
    this.pegadaCarbono = pegadaCarbono;
  }

  public Long getMedalhas() {
    return medalhas;
  }

  public void setMedalhas(Long medalhas) {
    this.medalhas = medalhas;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Long getCpf() {
    return idCPF;
  }

  public void setCpf(Long cpf) {
    this.idCPF = cpf;
  }

  public ImpactPanel getIdPainelDeImpacto() {
    return idPainelDeImpacto;
  }

  public void setIdPainelDeImpacto(ImpactPanel idPainelDeImpacto) {
    this.idPainelDeImpacto = idPainelDeImpacto;
  }

}
