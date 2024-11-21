package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.SuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.Suggestion;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeCreatedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityNotFoundException;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;
import com.fatec.cotia.projeto2.dsm2024.repositories.SuggestionRepository;

@Service
public class SuggestionService {

  @Autowired
  private CommonUserRepository commonUserRepository;
  @Autowired
  private SuggestionRepository suggestionRepository;

  public Suggestion createSuggestion(SuggestionDTO data)
      throws EntityNotFoundException, EntityCouldNotBeCreatedException {

    Optional<CommonUser> usuario = this.commonUserRepository.findByCpf(data.getUsuario_CPF());

    if (usuario.isEmpty()) {
      throw new EntityNotFoundException("O usuário dono da sugestão não foi encontrado");
    }

    Suggestion newSuggestion = new Suggestion();

    newSuggestion.setReducaoCO2Estimado(data.getReducaoCO2Estimado());
    newSuggestion.setUsuario_CPF(usuario.get());

    Suggestion savedSuggestion = this.suggestionRepository.save(newSuggestion);

    Optional<Suggestion> isSavedSuggestion = this.suggestionRepository.findById(savedSuggestion.getId());

    if (isSavedSuggestion.isEmpty()) {
      throw new EntityCouldNotBeCreatedException("A entidade não pode ser salva");
    }

    return savedSuggestion;
  }

  public Suggestion findSuggestionById(Long id) {

    Optional<Suggestion> foundSuggestion = this.suggestionRepository.findById(id);

    if (foundSuggestion.isEmpty()) {
      throw new EntityNotFoundException("Sugestão não encontrada");
    } else {
      return foundSuggestion.get();
    }
  }

  public HashMap<String, Suggestion> updateSuggestion(Long id, SuggestionDTO data) throws EntityNotFoundException {

    Optional<Suggestion> toUpdate = this.suggestionRepository.findById(id);

    if (toUpdate.isEmpty()) {
      throw new EntityNotFoundException("A sugestão a ser atualizada não foi encontrada");
    }

    HashMap<String, Suggestion> returnValue = new HashMap<>();
    returnValue.put("Old", new Suggestion(toUpdate.get()));

    Suggestion copy = new Suggestion(toUpdate.get());

    if (data.getReducaoCO2Estimado() != null) {
      copy.setReducaoCO2Estimado(data.getReducaoCO2Estimado());
    }

    if (data.getUsuario_CPF() != null) {

      Optional<CommonUser> newUser = this.commonUserRepository.findByCpf(data.getUsuario_CPF());

      if (newUser.isEmpty()) {
        throw new EntityNotFoundException("O usuário especificado não foi encontrado no sistema");
      }
      copy.setUsuario_CPF(newUser.get());
    }

    Suggestion updatedSuggestion = this.suggestionRepository.save(copy);

    returnValue.put("New", updatedSuggestion);

    return returnValue;

  }

  public Optional<Suggestion> deleteSuggestionById(Long id) {
    Optional<Suggestion> toDelete = this.suggestionRepository.findById(id);

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.suggestionRepository.deleteById(id);
      return toDelete;
    }
  }
}
