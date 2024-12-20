package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.CommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.ImpactPanelDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;

@Service
public class CommonUserService {

  @Autowired
  private ImpactPanelService impactPanelService;

  @Autowired
  private CommonUserRepository commonUserRepository;

  public Optional<CommonUser> findById(Long id) {
    return this.commonUserRepository.findById(id);
  }

  public Optional<CommonUser> createUser(CommonUserDTO data) {

    ImpactPanelDTO newImpactPanel = new ImpactPanelDTO();

    newImpactPanel.setImpactoColetivo("Nulo");
    newImpactPanel.setImpactoIndividual("Nulo");

    Optional<ImpactPanel> result = this.impactPanelService.createImpactPanel(newImpactPanel);

    if (result.isEmpty()) {
      return null;
    }

    CommonUser newUser = new CommonUser();

    newUser.setCpf(data.getCpf());
    newUser.setEmail(data.getEmail());
    newUser.setEndereco(data.getEndereco());
    newUser.setHabitosDiarios(data.getHabitosDiarios());
    newUser.setIdPainelDeImpacto(result.get());
    newUser.setMedalhas(data.getMedalhas());
    newUser.setNome(data.getNome());
    newUser.setSenha(data.getSenha());
    newUser.setPegadaCarbono(data.getPegadaCarbono());

    CommonUser savedUser = commonUserRepository.save(newUser);

    return Optional.of(savedUser);
  }

  public Optional<CommonUser> deleteUserById(Long id) {
    Optional<CommonUser> toDelete = this.commonUserRepository.findById(id);

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.impactPanelService
          .deleteById(toDelete.get().getIdPainelDeImpacto().getId());
      this.commonUserRepository.deleteById(id);
      return toDelete;
    }
  }

  public Optional<HashMap<String, CommonUser>> updateUser(Long id, CommonUserDTO data) {
    HashMap<String, CommonUser> list = new HashMap<>();

    Optional<CommonUser> old = this.commonUserRepository.findById(id);

    if (old.isEmpty()) {
      return null;
    }
    CommonUser existingUser = old.get();

    list.put("Old", new CommonUser(existingUser));

    if (data.getNome() != null) {

      existingUser.setNome(data.getNome());
    }
    if (data.getSenha() != null) {

      existingUser.setSenha(data.getSenha());
    }
    if (data.getCpf() != null) {

      existingUser.setCpf(data.getCpf());
    }
    if (data.getEmail() != null) {

      existingUser.setEmail(data.getEmail());
    }
    if (data.getEndereco() != null) {

      existingUser.setEndereco(data.getEndereco());
    }
    if (data.getHabitosDiarios() != null) {

      existingUser.setHabitosDiarios(data.getHabitosDiarios());
    }
    if (data.getMedalhas() != null) {

      existingUser.setMedalhas(data.getMedalhas());
    }
    if (data.getPegadaCarbono() != null) {

      existingUser.setPegadaCarbono(data.getPegadaCarbono());
    }

    CommonUser user = this.commonUserRepository.save(existingUser);

    list.put("New", user);

    return Optional.of(list);

  }

}
