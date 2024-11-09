package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.DailyHabitDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.DailyHabit;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;
import com.fatec.cotia.projeto2.dsm2024.repositories.DailyHabitRepository;

@Service
public class DailyHabitService {
  @Autowired
  private DailyHabitRepository dailyHabitRepository;

  @Autowired
  private CommonUserRepository commonUserRepository;

  public Optional<DailyHabit> createDailyHabit(DailyHabitDTO data) {

    Optional<CommonUser> user = this.commonUserRepository.findByCpf(data.getUsuario_CPF());

    if (user.isPresent()) {
      DailyHabit newDailyHabit = new DailyHabit(data);

      newDailyHabit.setUsuario_CPF(user.get());

      newDailyHabit = this.dailyHabitRepository.save(newDailyHabit);
      return Optional.of(newDailyHabit);

    } else {
      return null;
    }

  }

  public Optional<DailyHabit> findById(Long id) {
    return this.dailyHabitRepository.findById(id);
  }

  public Optional<HashMap<String, DailyHabit>> updateDailyHabit(Long id, DailyHabitDTO data) {
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
      Optional<CommonUser> user = this.commonUserRepository.findByCpf(data.getUsuario_CPF());
      if (user.isPresent()) {
        copy.setUsuario_CPF(user.get());
      } else {
        return null;
      }
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
