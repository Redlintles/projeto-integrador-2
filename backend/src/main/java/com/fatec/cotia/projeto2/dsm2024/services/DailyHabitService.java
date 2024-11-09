package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.cotia.projeto2.dsm2024.dtos.dailyHabit.CreateDailyHabitDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.dailyHabit.UpdateDailyHabitDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.DailyHabit;
import com.fatec.cotia.projeto2.dsm2024.repositories.DailyHabitRepository;

public class DailyHabitService {
  @Autowired
  private DailyHabitRepository dailyHabitRepository;

  public Optional<DailyHabit> createDailyHabit(CreateDailyHabitDTO data) {
    DailyHabit newDailyHabit = new DailyHabit(data);
    newDailyHabit = this.dailyHabitRepository.save(newDailyHabit);
    return Optional.of(newDailyHabit);
  }

  public Optional<DailyHabit> findById(Long id) {
    return this.dailyHabitRepository.findById(id);
  }

  public Optional<HashMap<String, DailyHabit>> updateDailyHabit(Long id, UpdateDailyHabitDTO data) {
    Optional<DailyHabit> toUpdate = this.dailyHabitRepository.findById(id);

    if (toUpdate.isEmpty()) {
      return null;
    }

    HashMap<String, DailyHabit> resultValue = new HashMap<>();
    resultValue.put("Old", toUpdate.get());
    DailyHabit copy = new DailyHabit(toUpdate.get());

    if (data.getAlimentacao() != null) {
      copy.setAlimentacao(data.getAlimentacao());
    }

    if (data.getCalculoPegadaCarbono() != null) {
      copy.setCalculoPegadaCarbono(data.getCalculoPegadaCarbono());
    }

    if (data.getDescarteLixo() != null) {
      copy.setDescarteLixo(data.getDescarteLixo());
    }

    if (data.getTransporte() != null) {
      copy.setTransporte(data.getTransporte());
    }

    if (data.getUsoEnergia() != null) {
      copy.setUsoEnergia(data.getUsoEnergia());
    }

    if (data.getUsuario_CPF() != null) {
      copy.setUsuario_CPF(data.getUsuario_CPF());
    }

    DailyHabit updatedDailyHabit = this.dailyHabitRepository.save(copy);
    resultValue.put("New", updatedDailyHabit);

    return Optional.of(resultValue);
  }

  public Optional<DailyHabit> deleteById(Long id) {
    Optional<DailyHabit> toDelete = this.dailyHabitRepository.findById(id);

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.dailyHabitRepository.deleteById(id);
      return toDelete;
    }
  }
}
