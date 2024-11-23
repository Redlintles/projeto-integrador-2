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

import com.fatec.cotia.projeto2.dsm2024.dtos.MedalDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.Medal;
import com.fatec.cotia.projeto2.dsm2024.interfaces.CreationGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.interfaces.UpdateGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.responses.StandardResponse;
import com.fatec.cotia.projeto2.dsm2024.services.MedalService;

@RestController
@RequestMapping("/medal")
public class MedalController {
  @Autowired
  private MedalService medalService;

  @GetMapping("/{id}")
  public ResponseEntity<StandardResponse<Medal>> findMedalById(@PathVariable Long id) {
    Medal result = this.medalService.findById(id);

    StandardResponse<Medal> response = new StandardResponse<>(result, "Medalha encontrada com sucesso!");

    return ResponseEntity.ok(response);

  }

  @PostMapping
  public ResponseEntity<StandardResponse<Medal>> createMedal(
      @Validated(CreationGroupInterface.class) @RequestBody MedalDTO data) {
    Medal result = this.medalService.createMedal(data);

    StandardResponse<Medal> response = new StandardResponse<>(result, "Medalha criada com sucesso!");

    return ResponseEntity.ok(response);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<StandardResponse<Medal>> deleteMedalById(@PathVariable Long id) {
    Medal result = this.medalService.deleteById(id);

    StandardResponse<Medal> response = new StandardResponse<>(result, "Medalha excluída com sucesso!");

    return ResponseEntity.ok(response);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<StandardResponse<HashMap<String, Medal>>> updateMedal(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody MedalDTO data) {
    HashMap<String, Medal> result = this.medalService.updateMedal(id, data);

    StandardResponse<HashMap<String, Medal>> response = new StandardResponse<>(result,
        "Medalha atualizada com sucesso!");

    return ResponseEntity.ok(response);

  }
}
