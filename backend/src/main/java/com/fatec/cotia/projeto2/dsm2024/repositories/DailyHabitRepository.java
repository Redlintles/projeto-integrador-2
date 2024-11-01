package com.fatec.cotia.projeto2.dsm2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.cotia.projeto2.dsm2024.entities.DailyHabit;

public interface DailyHabitRepository extends JpaRepository<DailyHabit, Long> {
  public DailyHabit findByUsuario_CPF(Long Usuario_CPF);
}
