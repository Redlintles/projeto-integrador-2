package com.fatec.cotia.projeto2.dsm2024.dtos.impactPanel;

import jakarta.validation.constraints.NotNull;

public class DeleteImpactPanelDTO {
  @NotNull
  private Long id;

  public DeleteImpactPanelDTO(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
