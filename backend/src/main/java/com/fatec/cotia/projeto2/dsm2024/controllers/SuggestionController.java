package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cotia.projeto2.dsm2024.dtos.SuggestionDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.Suggestion;
import com.fatec.cotia.projeto2.dsm2024.interfaces.CreationGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.interfaces.UpdateGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.services.SuggestionService;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

  @Autowired
  private SuggestionService suggestionService;

  @GetMapping("/{id}")
  public ResponseEntity<Suggestion> findOneById(@PathVariable Long id) {
    Suggestion obj = this.suggestionService.findSuggestionById(id);

    return ResponseEntity.ok(obj);

  }

  @PostMapping
  public ResponseEntity<Suggestion> createSuggestion(
      @Validated(CreationGroupInterface.class) @RequestBody SuggestionDTO data) {
    Suggestion newSuggestion = this.suggestionService.createSuggestion(data);

    return ResponseEntity.ok(newSuggestion);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<HashMap<String, Suggestion>> updateSuggestion(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody SuggestionDTO data) {
    HashMap<String, Suggestion> updatedSuggestion = this.suggestionService.updateSuggestion(id, data);

    return ResponseEntity.ok(updatedSuggestion);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Suggestion> deleteSuggestionById(@PathVariable Long id) {
    Suggestion deletedSuggestion = this.suggestionService.deleteSuggestionById(id);

    return ResponseEntity.ok(deletedSuggestion);

  }

}
