package com.fatec.cotia.projeto2.dsm2024.dtos.medal;

import jakarta.validation.constraints.NotNull;

public class FindMedalDTO {
  @NotNull
  private Long id;

  public FindMedalDTO() {

  }

  public FindMedalDTO(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
