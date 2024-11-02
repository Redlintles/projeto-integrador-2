package com.fatec.cotia.projeto2.dsm2024.dtos.impactPanel;

import jakarta.validation.constraints.NotNull;

public class FindImpactPanelDTO {
  @NotNull
  private Long id;

  public FindImpactPanelDTO() {

  }

  public FindImpactPanelDTO(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
