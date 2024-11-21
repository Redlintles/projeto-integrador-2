package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.DailyHabitDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.DailyHabit;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeCreatedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeDeletedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityNotFoundException;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;
import com.fatec.cotia.projeto2.dsm2024.repositories.DailyHabitRepository;

@Service
public class DailyHabitService {
  @Autowired
  private DailyHabitRepository dailyHabitRepository;

  @Autowired
  private CommonUserRepository commonUserRepository;

  public DailyHabit createDailyHabit(DailyHabitDTO data)
      throws EntityCouldNotBeCreatedException, EntityNotFoundException {
    Optional<CommonUser> user = this.commonUserRepository.findByCpf(data.getUsuario_CPF());

    if (user.isPresent()) {
      DailyHabit newDailyHabit = new DailyHabit(data);

      newDailyHabit.setUsuario_CPF(user.get());
      newDailyHabit.setCalculoPegadaCarbono(data.getCalculoPegadaCarbono());
      newDailyHabit.setDescarteLixo(data.getDescarteLixo());
      newDailyHabit.setAlimentacao(data.getAlimentacao());
      newDailyHabit.setTransporte(data.getTransporte());
      newDailyHabit.setUsoEnergia(data.getUsoEnergia());

      newDailyHabit = this.dailyHabitRepository.save(newDailyHabit);

      Optional<DailyHabit> isSaved = this.dailyHabitRepository.findById(newDailyHabit.getId());

      if (isSaved.isEmpty()) {
        throw new EntityCouldNotBeCreatedException(
            "O hábito diário não pode ser criado por causa de algum erro interno");
      }

      return newDailyHabit;

    } else {
      throw new EntityNotFoundException("O usuário referido em Daily Habit não foi encontrado");
    }

  }

  public DailyHabit findById(Long id) throws EntityNotFoundException {

    Optional<DailyHabit> toFind = this.dailyHabitRepository.findById(id);

    if (toFind.isPresent()) {
      return toFind.get();
    } else {
      throw new EntityNotFoundException("O hábito diário não fora encontrada");
    }
  }

  public HashMap<String, DailyHabit> updateDailyHabit(Long id, DailyHabitDTO data) {
    Optional<DailyHabit> toUpdate = this.dailyHabitRepository.findById(id);

    if (toUpdate.isEmpty()) {
      throw new EntityNotFoundException("O hábito a ser atualizado não foi encontrado");
    }

    HashMap<String, DailyHabit> resultValue = new HashMap<>();
    resultValue.put("Old", new DailyHabit(toUpdate.get()));
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
        throw new EntityNotFoundException("O Usuário não foi encontrado");
      }
    }

    DailyHabit updatedDailyHabit = this.dailyHabitRepository.save(copy);
    resultValue.put("New", updatedDailyHabit);

    return resultValue;
  }

  public Optional<DailyHabit> deleteById(Long id) throws EntityNotFoundException, EntityCouldNotBeDeletedException {
    Optional<DailyHabit> toDelete = this.dailyHabitRepository.findById(id);

    if (toDelete.isEmpty()) {
      throw new EntityNotFoundException("Hábito não encontrado");
    } else {
      this.dailyHabitRepository.deleteById(id);

      Optional<DailyHabit> isDeleted = this.dailyHabitRepository.findById(id);

      if (isDeleted.isEmpty()) {
        return toDelete;
      } else {
        throw new EntityCouldNotBeDeletedException("Daily Habit não pode ser deletado");
      }
    }
  }
}
