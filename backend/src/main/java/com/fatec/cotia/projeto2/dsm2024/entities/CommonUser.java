package com.fatec.cotia.projeto2.dsm2024.entities;

import com.fatec.cotia.projeto2.dsm2024.dtos.CommonUserDTO;

import jakarta.persistence.Column;
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
  private Long id;

  @Column(length = 11, nullable = false, unique = true)
  private String cpf;

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
  @JoinColumn(name = "id")
  private ImpactPanel idPainelDeImpacto;

  public CommonUser() {
  }

  public CommonUser(
      String cpf,
      String nome,
      String email,
      String senha,
      Long habitosDiarios,
      Long pegadaCarbono,
      Long medalhas,
      String endereco,
      ImpactPanel idPainelDeImpacto) {
    this.cpf = cpf;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.habitosDiarios = habitosDiarios;
    this.idPainelDeImpacto = idPainelDeImpacto;
    this.medalhas = medalhas;
    this.endereco = endereco;
    this.pegadaCarbono = pegadaCarbono;

  }

  public CommonUser(CommonUserDTO data) {
    this.cpf = data.getCpf();
    this.nome = data.getNome();
    this.email = data.getEmail();
    this.habitosDiarios = data.getHabitosDiarios();
    this.senha = data.getSenha();
    this.endereco = data.getEndereco();
    this.medalhas = data.getMedalhas();
    this.pegadaCarbono = data.getPegadaCarbono();
  }

  public CommonUser(CommonUser data) {
    this.id = data.getId();
    this.cpf = data.getCpf();
    this.nome = data.getNome();
    this.email = data.getEmail();
    this.habitosDiarios = data.getHabitosDiarios();
    this.senha = data.getSenha();
    this.endereco = data.getEndereco();
    this.idPainelDeImpacto = data.getIdPainelDeImpacto();
    this.medalhas = data.getMedalhas();
    this.pegadaCarbono = data.getPegadaCarbono();
  }

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

  public ImpactPanel getIdPainelDeImpacto() {
    return idPainelDeImpacto;
  }

  public void setIdPainelDeImpacto(ImpactPanel idPainelDeImpacto) {
    this.idPainelDeImpacto = idPainelDeImpacto;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
