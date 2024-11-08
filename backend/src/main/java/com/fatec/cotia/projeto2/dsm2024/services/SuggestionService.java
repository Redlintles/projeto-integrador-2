package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.suggestion.CreateSuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.Suggestion;
import com.fatec.cotia.projeto2.dsm2024.repositories.SuggestionRepository;

@Service
public class SuggestionService {
  private SuggestionRepository suggestionRepository;

  public Optional<Suggestion> createSuggestion(CreateSuggestionDTO data) {
    Suggestion newSuggestion = new Suggestion();

    newSuggestion.setReducaoCO2Estimado(data.getReducaoCO2Estimado());
    newSuggestion.setUsuario_CPF(data.getUsuario_CPF());

    Suggestion savedSuggestion = this.suggestionRepository.save(newSuggestion);

    return Optional.of(savedSuggestion);
  }

}
