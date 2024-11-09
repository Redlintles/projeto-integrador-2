package com.fatec.cotia.projeto2.dsm2024.dtos;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.interfaces.CreationGroupInterface;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommonUserDTO {

  @NotNull(groups = CreationGroupInterface.class)
  @Size(min = 11, max = 11)
  private String cpf;
  @NotNull(groups = CreationGroupInterface.class)
  @Size(min = 0, max = 45)
  private String nome;
  @NotNull(groups = CreationGroupInterface.class)
  @Size(min = 0, max = 45)
  private String senha;
  @Email
  @NotNull(groups = CreationGroupInterface.class)
  @Size(min = 0, max = 45)
  private String email;
  @NotNull(groups = CreationGroupInterface.class)
  @Size(min = 0, max = 90)
  private String endereco;
  @NotNull(groups = CreationGroupInterface.class)
  private Long habitosDiarios;
  @NotNull(groups = CreationGroupInterface.class)
  private Long medalhas;
  @NotNull(groups = CreationGroupInterface.class)
  private Long pegadaCarbono;

  private ImpactPanel painelDeImpacto;

  public CommonUserDTO() {
  }

  public CommonUserDTO(String cpf,
      String nome,
      String email,
      String senha,
      Long habitosDiarios,
      Long pegadaCarbono,
      Long medalhas,
      String endereco) {
    this.cpf = cpf;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.habitosDiarios = habitosDiarios;
    this.medalhas = medalhas;
    this.endereco = endereco;
    this.pegadaCarbono = pegadaCarbono;
  }

  public CommonUserDTO(CommonUserDTO data) {
    this.cpf = data.getCpf();
    this.medalhas = data.getMedalhas();
    this.endereco = data.getEndereco();
    this.email = data.getEmail();
    this.nome = data.getNome();
    this.senha = data.getSenha();
    this.habitosDiarios = data.getHabitosDiarios();
    this.pegadaCarbono = data.getPegadaCarbono();
    this.painelDeImpacto = data.getPainelDeImpacto();
  }

  public CommonUserDTO(CommonUser data) {
    this.cpf = data.getCpf();
    this.medalhas = data.getMedalhas();
    this.endereco = data.getEndereco();
    this.email = data.getEmail();
    this.nome = data.getNome();
    this.senha = data.getSenha();
    this.habitosDiarios = data.getHabitosDiarios();
    this.pegadaCarbono = data.getPegadaCarbono();
    this.painelDeImpacto = data.getIdPainelDeImpacto();
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Long getHabitosDiarios() {
    return habitosDiarios;
  }

  public void setHabitosDiarios(Long habitosDiarios) {
    this.habitosDiarios = habitosDiarios;
  }

  public Long getMedalhas() {
    return medalhas;
  }

  public void setMedalhas(Long medalhas) {
    this.medalhas = medalhas;
  }

  public Long getPegadaCarbono() {
    return pegadaCarbono;
  }

  public void setPegadaCarbono(Long pegadaCarbono) {
    this.pegadaCarbono = pegadaCarbono;
  }

  public ImpactPanel getPainelDeImpacto() {
    return painelDeImpacto;
  }

  public void setPainelDeImpacto(ImpactPanel painelDeImpacto) {
    this.painelDeImpacto = painelDeImpacto;
  }

}
