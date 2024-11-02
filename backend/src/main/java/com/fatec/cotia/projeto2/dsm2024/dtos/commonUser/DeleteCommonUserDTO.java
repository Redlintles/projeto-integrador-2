package com.fatec.cotia.projeto2.dsm2024.dtos.commonUser;

import jakarta.validation.constraints.NotNull;

public class DeleteCommonUserDTO {
  @NotNull
  private Long id;

  public DeleteCommonUserDTO() {

  }

  public DeleteCommonUserDTO(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
