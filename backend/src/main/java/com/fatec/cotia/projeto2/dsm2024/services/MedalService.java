
package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.cotia.projeto2.dsm2024.dtos.medal.CreateMedalDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.medal.DeleteMedalDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.medal.FindMedalDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.medal.UpdateMedalDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.Medal;
import com.fatec.cotia.projeto2.dsm2024.repositories.MedalRepository;

public class MedalService {

  @Autowired
  MedalRepository medalRepository;

  public Optional<Medal> createMedal(CreateMedalDTO data) {

    Medal newMedal = new Medal(data);
    Medal createdMedal = this.medalRepository.save(newMedal);

    return Optional.of(createdMedal);

  }

  public Optional<Medal> findById(FindMedalDTO data) {
    return this.medalRepository.findById(data.getId());
  }

  public Optional<Medal> deleteById(DeleteMedalDTO data) {
    Optional<Medal> toDelete = this.medalRepository.findById(data.getId());

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.medalRepository.deleteById(data.getId());
      return toDelete;
    }
  }

  public Optional<HashMap<String, Medal>> updateMedal(Long id, UpdateMedalDTO data) {
    Optional<Medal> toUpdate = this.medalRepository.findById(id);

    if (toUpdate.isEmpty()) {
      return null;
    }

    HashMap<String, Medal> result = new HashMap<>();

    Medal copy = new Medal(toUpdate.get());

    result.put("Old", toUpdate.get());

    if (data.getDescricao() != null) {
      copy.setDescricao(data.getDescricao());
    }
    if (data.getNome() != null) {
      copy.setNome(data.getNome());
    }
    if (data.getUsuario_CPF() != null) {
      copy.setUsuario_CPF(data.getUsuario_CPF());
    }
    if (data.getRecompensa() != null) {
      copy.setRecompensa(data.getRecompensa());
    }

    Medal updatedMedal = this.medalRepository.save(copy);
    result.put("New", updatedMedal);

    return Optional.of(result);
  }
}
