package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.CreateCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.DeleteCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.FindCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.UpdateCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.impactPanel.CreateImpactPanelDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;

@Service
public class CommonUserService {

  @Autowired
  private ImpactPanelService impactPanelService;

  @Autowired
  private CommonUserRepository commonUserRepository;

  public Optional<CommonUser> findById(FindCommonUserDTO data) {
    return this.commonUserRepository.findById(data.getId());
  }

  public Optional<CommonUser> createUser(CreateCommonUserDTO data) {

    CreateImpactPanelDTO newImpactPanel = new CreateImpactPanelDTO();

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

  public Optional<CommonUser> deleteUserById(DeleteCommonUserDTO data) {
    Optional<CommonUser> toDelete = this.commonUserRepository.findById(data.getId());

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.commonUserRepository.deleteById(data.getId());
      return toDelete;
    }
  }

  public Optional<HashMap<String, CommonUser>> updateUser(UpdateCommonUserDTO data) {
    HashMap<String, CommonUser> list = new HashMap<>();

    Optional<CommonUser> old = this.commonUserRepository.findById(data.getId());

    if (old.isEmpty()) {
      return null;
    }
    CommonUser oldUser = old.get();
    list.put("Old", oldUser);

    if (data.getNome() != null) {

      oldUser.setNome(data.getNome());
    }
    if (data.getSenha() != null) {

      oldUser.setSenha(data.getSenha());
    }
    if (data.getCpf() != null) {

      oldUser.setCpf(data.getCpf());
    }
    if (data.getEmail() != null) {

      oldUser.setEmail(data.getEmail());
    }
    if (data.getEndereco() != null) {

      oldUser.setEndereco(data.getEndereco());
    }
    if (data.getHabitosDiarios() != null) {

      oldUser.setHabitosDiarios(data.getHabitosDiarios());
    }
    if (data.getIdPainelDeImpacto() != null) {

      oldUser.setIdPainelDeImpacto(data.getIdPainelDeImpacto());
    }
    if (data.getMedalhas() != null) {

      oldUser.setMedalhas(data.getMedalhas());
    }
    if (data.getPegadaCarbono() != null) {

      oldUser.setPegadaCarbono(data.getPegadaCarbono());
    }

    CommonUser user = this.commonUserRepository.save(oldUser);

    list.put("New", user);

    return Optional.of(list);

  }

}
