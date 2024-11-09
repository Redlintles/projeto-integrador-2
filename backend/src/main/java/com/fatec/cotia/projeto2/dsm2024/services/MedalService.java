
package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.MedalDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.Medal;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;
import com.fatec.cotia.projeto2.dsm2024.repositories.MedalRepository;

@Service
public class MedalService {

  @Autowired
  private MedalRepository medalRepository;

  @Autowired
  private CommonUserRepository commonUserRepository;

  public Optional<Medal> createMedal(MedalDTO data) {

    Optional<CommonUser> user = this.commonUserRepository.findByCpf(data.getUsuario_CPF());

    if (user.isPresent()) {

      Medal newMedal = new Medal(data);

      newMedal.setUsuario_CPF(user.get());

      Medal createdMedal = this.medalRepository.save(newMedal);
      return Optional.of(createdMedal);
    } else {
      return null;
    }

  }

  public Optional<Medal> findById(Long id) {
    return this.medalRepository.findById(id);
  }

  public Optional<Medal> deleteById(Long id) {
    Optional<Medal> toDelete = this.medalRepository.findById(id);

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.medalRepository.deleteById(id);
      return toDelete;
    }
  }

  public Optional<HashMap<String, Medal>> updateMedal(Long id, MedalDTO data) {
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

      Optional<CommonUser> user = this.commonUserRepository.findByCpf(data.getUsuario_CPF());

      if (user.isPresent()) {
        copy.setUsuario_CPF(user.get());
      } else {
        return null;
      }

    }
    if (data.getRecompensa() != null) {
      copy.setRecompensa(data.getRecompensa());
    }

    Medal updatedMedal = this.medalRepository.save(copy);
    result.put("New", updatedMedal);

    return Optional.of(result);
  }
}
