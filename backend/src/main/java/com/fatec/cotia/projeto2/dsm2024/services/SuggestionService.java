package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.suggestion.CreateSuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.suggestion.DeleteSuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.suggestion.FindSuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.suggestion.UpdateSuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.Suggestion;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;
import com.fatec.cotia.projeto2.dsm2024.repositories.SuggestionRepository;

@Service
public class SuggestionService {

  @Autowired
  private CommonUserRepository commonUserRepository;
  @Autowired
  private SuggestionRepository suggestionRepository;

  public Optional<Suggestion> createSuggestion(CreateSuggestionDTO data) {

    Optional<CommonUser> usuario = this.commonUserRepository.findByCpf(data.getUsuario_CPF());

    if (usuario.isEmpty()) {
      return null;
    }

    Suggestion newSuggestion = new Suggestion();

    newSuggestion.setReducaoCO2Estimado(data.getReducaoCO2Estimado());
    newSuggestion.setUsuario_CPF(usuario.get());

    Suggestion savedSuggestion = this.suggestionRepository.save(newSuggestion);

    return Optional.of(savedSuggestion);
  }

  public Optional<Suggestion> findSuggestionById(FindSuggestionDTO data) {
    return this.suggestionRepository.findById(data.getId());
  }

  public Optional<HashMap<String, Suggestion>> updateSuggestion(Long id, UpdateSuggestionDTO data) {

    Optional<Suggestion> toUpdate = this.suggestionRepository.findById(id);

    if (toUpdate.isEmpty()) {
      return null;
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
        return null;
      }
      copy.setUsuario_CPF(newUser.get());
    }

    Suggestion updatedSuggestion = this.suggestionRepository.save(copy);

    returnValue.put("New", updatedSuggestion);

    return Optional.of(returnValue);

  }

  public Optional<Suggestion> deleteSuggestionById(DeleteSuggestionDTO data) {
    Optional<Suggestion> toDelete = this.suggestionRepository.findById(data.getId());

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.suggestionRepository.deleteById(data.getId());
      return toDelete;
    }
  }
}
