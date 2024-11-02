package com.fatec.cotia.projeto2.dsm2024.dtos.dailyHabit;

import jakarta.validation.constraints.NotNull;

public class FindDailyHabitDTO {
  @NotNull
  private Long id;

  public FindDailyHabitDTO() {
  }

  public FindDailyHabitDTO(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
