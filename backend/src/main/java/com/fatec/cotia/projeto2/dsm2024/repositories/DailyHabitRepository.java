package com.fatec.cotia.projeto2.dsm2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.cotia.projeto2.dsm2024.entities.DailyHabit;

@Repository
public interface DailyHabitRepository extends JpaRepository<DailyHabit, Long> {

}
