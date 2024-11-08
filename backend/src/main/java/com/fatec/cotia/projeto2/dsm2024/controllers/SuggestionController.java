package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cotia.projeto2.dsm2024.dtos.suggestion.CreateSuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.suggestion.FindSuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.Suggestion;
import com.fatec.cotia.projeto2.dsm2024.services.SuggestionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

  @Autowired
  private SuggestionService suggestionService;

  @GetMapping("/{id}")
  public ResponseEntity<Suggestion> findOneById(@PathVariable Long id) {
    Optional<Suggestion> obj = this.suggestionService.findSuggestionById(new FindSuggestionDTO(id));
    if (obj.isPresent()) {
      return ResponseEntity.ok(obj.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Suggestion> createSuggestion(@Valid @RequestBody CreateSuggestionDTO data) {
    Optional<Suggestion> newSuggestion = this.suggestionService.createSuggestion(data);

    if (newSuggestion.isPresent()) {
      return ResponseEntity.ok(newSuggestion.get());
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

}
