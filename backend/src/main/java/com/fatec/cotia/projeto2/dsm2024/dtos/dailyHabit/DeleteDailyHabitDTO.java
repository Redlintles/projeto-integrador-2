package com.fatec.cotia.projeto2.dsm2024.dtos.dailyHabit;

import jakarta.validation.constraints.NotNull;

public class DeleteDailyHabitDTO {
  @NotNull
  private Long id;

  public DeleteDailyHabitDTO() {
  }

  public DeleteDailyHabitDTO(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
