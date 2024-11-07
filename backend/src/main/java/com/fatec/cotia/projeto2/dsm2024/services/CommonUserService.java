package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.CreateCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.DeleteCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.FindCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;

@Service
public class CommonUserService {
  @Autowired
  private CommonUserRepository commonUserRepository;

  public Optional<CommonUser> findById(FindCommonUserDTO data) {
    return this.commonUserRepository.findById(data.getId());
  }

  public Optional<CommonUser> createUser(CreateCommonUserDTO data) {
    CommonUser newUser = new CommonUser();

    newUser.setCpf(data.getCpf());
    newUser.setEmail(data.getEmail());
    newUser.setEndereco(data.getEndereco());
    newUser.setHabitosDiarios(data.getHabitosDiarios());
    newUser.setIdPainelDeImpacto(data.getIdPainelDeImpacto());
    newUser.setMedalhas(data.getMedalhas());
    newUser.setNome(data.getNome());
    newUser.setSenha(data.getSenha());
    newUser.setPegadaCarbono(data.getPegadaCarbono());

    CommonUser savedUser = commonUserRepository.save(newUser);

    return Optional.of(savedUser);
  }

  public Optional<CommonUser> deleteUserById(DeleteCommonUserDTO data) {
    Optional<CommonUser> toDelete = this.commonUserRepository.findById(data.getId());

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.commonUserRepository.deleteById(data.getId());
      return toDelete;
    }
  }

}
