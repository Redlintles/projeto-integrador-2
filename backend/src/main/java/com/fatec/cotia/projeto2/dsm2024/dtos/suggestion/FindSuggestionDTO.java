package com.fatec.cotia.projeto2.dsm2024.dtos.suggestion;

import jakarta.validation.constraints.NotNull;

public class FindSuggestionDTO {
  @NotNull
  private Long id;

  public FindSuggestionDTO() {
  }

  public FindSuggestionDTO(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
