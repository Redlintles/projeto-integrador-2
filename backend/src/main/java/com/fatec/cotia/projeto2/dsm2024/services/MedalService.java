
package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.MedalDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.Medal;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeCreatedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeDeletedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityNotFoundException;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;
import com.fatec.cotia.projeto2.dsm2024.repositories.MedalRepository;

@Service
public class MedalService {

  @Autowired
  private MedalRepository medalRepository;

  @Autowired
  private CommonUserRepository commonUserRepository;

  public Medal createMedal(MedalDTO data) throws EntityNotFoundException, EntityCouldNotBeCreatedException {

    Optional<CommonUser> user = this.commonUserRepository.findByCpf(data.getUsuario_CPF());

    if (user.isPresent()) {

      Medal newMedal = new Medal(data);

      newMedal.setUsuario_CPF(user.get());
      newMedal.setDescricao(data.getDescricao());
      newMedal.setNome(data.getNome());
      newMedal.setRecompensa(data.getRecompensa());

      Medal createdMedal = this.medalRepository.save(newMedal);

      Optional<Medal> savedMedal = this.medalRepository.findById(createdMedal.getId());

      if (savedMedal.isPresent()) {
        return savedMedal.get();
      } else {
        throw new EntityCouldNotBeCreatedException("A entidade não pode ser criada");
      }
    } else {
      throw new EntityNotFoundException("O usuário não pode ser encontrado");
    }

  }

  public Medal findById(Long id) throws EntityNotFoundException {

    Optional<Medal> toFind = this.medalRepository.findById(id);

    if (toFind.isEmpty()) {
      throw new EntityNotFoundException("A medalha não pode ser encontrada");
    } else {
      return toFind.get();
    }
  }

  public Medal deleteById(Long id) throws EntityNotFoundException, EntityCouldNotBeCreatedException {
    Optional<Medal> toDelete = this.medalRepository.findById(id);

    if (toDelete.isEmpty()) {
      throw new EntityNotFoundException("Medalha não foi encontrada");
    } else {
      this.medalRepository.deleteById(id);

      Optional<Medal> isDeleted = this.medalRepository.findById(id);

      if (isDeleted.isEmpty()) {

        return toDelete.get();
      } else {
        throw new EntityCouldNotBeDeletedException("A medalha não pode ser deletada");
      }
    }
  }

  public HashMap<String, Medal> updateMedal(Long id, MedalDTO data) throws EntityNotFoundException {
    Optional<Medal> toUpdate = this.medalRepository.findById(id);

    if (toUpdate.isEmpty()) {
      throw new EntityNotFoundException("A medalha a ser atualizada não foi encontrada");
    }

    HashMap<String, Medal> result = new HashMap<>();

    Medal copy = new Medal(toUpdate.get());

    result.put("Old", new Medal(toUpdate.get()));

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
        throw new EntityNotFoundException("O usuário especificado não foi encontrado no sistema");
      }

    }
    if (data.getRecompensa() != null) {
      copy.setRecompensa(data.getRecompensa());
    }

    Medal updatedMedal = this.medalRepository.save(copy);
    result.put("New", updatedMedal);

    return result;
  }
}
