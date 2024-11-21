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
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeCreatedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeDeletedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeUpdatedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityNotFoundException;
import com.fatec.cotia.projeto2.dsm2024.errors.InvalidInputDataException;
import com.fatec.cotia.projeto2.dsm2024.errors.TokenAlreadyExistsException;
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

  public CommonUser findById(Long id) throws EntityNotFoundException {
    Optional<CommonUser> user = this.commonUserRepository.findById(id);

    if (user.isPresent()) {
      return user.get();
    } else {
      throw new EntityNotFoundException(String.format("O usuário %d não foi encontrado", id));
    }

  }

  public HashMap<String, Object> loginUser(String email, String password)
      throws EntityNotFoundException, TokenAlreadyExistsException, EntityCouldNotBeCreatedException,
      InvalidInputDataException {
    Optional<CommonUser> optionalUser = this.commonUserRepository.findByEmail(email);
    if (optionalUser.isEmpty()) {
      throw new EntityNotFoundException("Usuário Não encontrado");
    }

    CommonUser user = optionalUser.get();

    Optional<Token> existingToken = this.tokenRepository.findByCpf(user.getCpf());

    if (existingToken.isPresent()) {
      throw new TokenAlreadyExistsException("Já existe um token em vigor para o usuário especificado!");
    }
    if (user.getSenha().equals(password)) {
      Token newToken = new Token();
      newToken.setCreatedAt(LocalDateTime.now());
      newToken.setToken(UUID.randomUUID().toString());
      newToken.setCpf(user.getCpf());

      Token savedToken = this.tokenRepository.save(newToken);

      Optional<Token> foundToken = this.tokenRepository.findByCpf(user.getCpf());

      if (foundToken.isPresent()) {
        HashMap<String, Object> returnValue = new HashMap<>();
        returnValue.put("user", user);
        returnValue.put("token", savedToken);
        return returnValue;
      } else {
        throw new EntityCouldNotBeCreatedException("Token Could Not be saved by a unknown reason");
      }

    } else {
      throw new InvalidInputDataException("Usuário ou senha Inválidos");
    }

  }

  public HashMap<String, Object> createUser(CommonUserDTO data) throws EntityCouldNotBeCreatedException {

    ImpactPanelDTO newImpactPanel = new ImpactPanelDTO();

    newImpactPanel.setImpactoColetivo("Nulo");
    newImpactPanel.setImpactoIndividual("Nulo");

    Optional<ImpactPanel> result = this.impactPanelService.createImpactPanel(newImpactPanel);

    if (result.isEmpty()) {
      throw new EntityCouldNotBeCreatedException(
          "O painel de impacto referente ao novo usuário não pode ser criado propriamente");
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

    Optional<CommonUser> foundUser = this.commonUserRepository.findByCpf(data.getCpf());

    if (foundUser.isEmpty()) {
      throw new EntityCouldNotBeCreatedException("O Novo usuário não pode ser criado");
    }

    Token newAccountToken = new Token();

    newAccountToken.setCpf(savedUser.getCpf());
    newAccountToken.setToken(UUID.randomUUID().toString());
    newAccountToken.setCreatedAt(LocalDateTime.now());

    Token savedToken = this.tokenRepository.save(newAccountToken);

    Optional<Token> foundToken = this.tokenRepository.findByCpf(savedUser.getCpf());

    HashMap<String, Object> returnValue = new HashMap<>();

    if (foundToken.isPresent()) {
      returnValue.put("User", savedUser);
      returnValue.put("Token", savedToken);
      return returnValue;
    } else {
      throw new EntityCouldNotBeCreatedException("O Token de sessão referente ao novo usuário não pode ser criado");
    }

  }

  public CommonUser deleteUserById(Long id) throws EntityNotFoundException, EntityCouldNotBeDeletedException {
    Optional<CommonUser> toDelete = this.commonUserRepository.findById(id);

    if (toDelete.isEmpty()) {
      throw new EntityNotFoundException("O Usuário não pode ser encontrado, talvez ele já tenha sido excluído!");
    } else {
      this.impactPanelService
          .deleteById(toDelete.get().getIdPainelDeImpacto().getId());
      this.commonUserRepository.deleteById(id);

      Optional<CommonUser> isDeleted = this.commonUserRepository.findById(id);

      if (isDeleted.isEmpty()) {
        return toDelete.get();
      } else {
        throw new EntityCouldNotBeDeletedException("O usuário não pode ser deletado devido à algum erro interno");
      }
    }
  }

  public HashMap<String, CommonUser> updateUser(Long id, CommonUserDTO data)
      throws EntityCouldNotBeUpdatedException, EntityNotFoundException {
    HashMap<String, CommonUser> list = new HashMap<>();

    Optional<CommonUser> old = this.commonUserRepository.findById(id);

    if (old.isEmpty()) {
      throw new EntityNotFoundException("O Usuário a ser atualizado não foi encontrado");
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

    Optional<CommonUser> foundUser = this.commonUserRepository.findByCpf(data.getCpf());

    if (foundUser.isEmpty()) {
      // EntityCouldNotBeUpdated
      throw new EntityCouldNotBeUpdatedException("Ocorreu um erro na atualização");
    }

    list.put("New", user);

    return list;

  }

}
