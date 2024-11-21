package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.HashMap;
import java.util.Optional;

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
import com.fatec.cotia.projeto2.dsm2024.services.MedalService;

@RestController
@RequestMapping("/medal")
public class MedalController {
  @Autowired
  private MedalService medalService;

  @GetMapping("/{id}")
  public ResponseEntity<Medal> findMedalById(@PathVariable Long id) {
    Medal result = this.medalService.findById(id);

    return ResponseEntity.ok(result);

  }

  @PostMapping
  public ResponseEntity<Medal> createMedal(@Validated(CreationGroupInterface.class) @RequestBody MedalDTO data) {
    Medal result = this.medalService.createMedal(data);

    return ResponseEntity.ok(result);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Medal> deleteMedalById(@PathVariable Long id) {
    Optional<Medal> result = this.medalService.deleteById(id);

    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PatchMapping("/{id}")
  public ResponseEntity<HashMap<String, Medal>> updateMedal(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody MedalDTO data) {
    Optional<HashMap<String, Medal>> result = this.medalService.updateMedal(id, data);
    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
