package com.fatec.cotia.projeto2.dsm2024.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.CommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.ImpactPanelDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.entities.Token;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;
import com.fatec.cotia.projeto2.dsm2024.repositories.TokenRepository;

@Service
public class CommonUserService {

  @Autowired
  private ImpactPanelService impactPanelService;

  @Autowired
  private TokenRepository tokenRepository;

  @Autowired
  private CommonUserRepository commonUserRepository;

  public Optional<CommonUser> findById(Long id) {
    return this.commonUserRepository.findById(id);
  }

  public Optional<Token> loginUser(String email, String password) {
    Optional<CommonUser> optionalUser = this.commonUserRepository.findByEmail(email);
    if (optionalUser.isEmpty()) {
      return null;
    }

    CommonUser user = optionalUser.get();

    Optional<Token> existingToken = this.tokenRepository.findByCpf(user.getCpf());

    if (existingToken.isPresent()) {
      return null;
    }
    if (user.getSenha().equals(password)) {
      Token newToken = new Token();
      newToken.setCreatedAt(LocalDateTime.now());
      newToken.setToken(UUID.randomUUID().toString());
      newToken.setCpf(user.getCpf());

      Token savedToken = this.tokenRepository.save(newToken);

      if (savedToken != null) {
        return Optional.of(savedToken);
      }
    }

    return null;

  }

  public Optional<HashMap<String, Object>> createUser(CommonUserDTO data) {

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

    Token newAccountToken = new Token();

    newAccountToken.setCpf(savedUser.getCpf());
    newAccountToken.setToken(UUID.randomUUID().toString());
    newAccountToken.setCreatedAt(LocalDateTime.now());

    Token savedToken = this.tokenRepository.save(newAccountToken);

    HashMap<String, Object> returnValue = new HashMap<>();

    if (savedToken != null) {
      returnValue.put("User", savedUser);
      returnValue.put("Token", savedToken);
      return Optional.of(returnValue);
    } else {
      return null;
    }

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
