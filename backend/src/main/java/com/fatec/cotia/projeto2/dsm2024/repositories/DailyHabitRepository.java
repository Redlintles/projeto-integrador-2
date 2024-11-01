package com.fatec.cotia.projeto2.dsm2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.DailyHabit;

public interface DailyHabitRepository extends JpaRepository<DailyHabit, CommonUser> {
  public DailyHabit findByUsuario_idCPF(Long Usuario_idCPF);
}
