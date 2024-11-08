package com.fatec.cotia.projeto2.dsm2024.entities;

import com.fatec.cotia.projeto2.dsm2024.dtos.medal.CreateMedalDTO;

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
  private Long id;

  @Column(length = 45, nullable = false)
  private String nome;
  @Column(length = 45, nullable = false)
  private String descricao;
  @Column(length = 90, nullable = false)
  private String recompensa;

  @ManyToOne
  @JoinColumn(name = "cpf")
  private CommonUser usuario_CPF;

  public Medal() {
  }

  public Medal(
      String nome,
      String descricao,
      String recompensa,
      CommonUser usuario_CPF) {
    this.nome = nome;
    this.descricao = descricao;
    this.recompensa = recompensa;
    this.usuario_CPF = usuario_CPF;

  }

  public Medal(Medal data) {
    this.nome = data.getNome();
    this.descricao = data.getDescricao();
    this.recompensa = data.getRecompensa();
    this.usuario_CPF = data.getUsuario_CPF();
  }

  public Medal(CreateMedalDTO data) {
    this.nome = data.getNome();
    this.descricao = data.getDescricao();
    this.recompensa = data.getRecompensa();
    this.usuario_CPF = data.getUsuario_CPF();
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

  public CommonUser getUsuario_CPF() {
    return usuario_CPF;
  }

  public void setUsuario_CPF(CommonUser usuario_CPF) {
    this.usuario_CPF = usuario_CPF;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
