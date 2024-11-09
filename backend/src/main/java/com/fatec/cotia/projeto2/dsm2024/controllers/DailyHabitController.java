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

import com.fatec.cotia.projeto2.dsm2024.dtos.DailyHabitDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.DailyHabit;
import com.fatec.cotia.projeto2.dsm2024.interfaces.CreationGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.interfaces.UpdateGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.services.DailyHabitService;

public class DailyHabitController {
  @Autowired
  private DailyHabitService dailyHabitService;

  @GetMapping("/{id}")
  public ResponseEntity<DailyHabit> findDailyHabit(@PathVariable Long id) {
    Optional<DailyHabit> result = this.dailyHabitService.findById(id);

    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<DailyHabit> createDailyHabit(
      @Validated(CreationGroupInterface.class) @RequestBody DailyHabitDTO data) {
    Optional<DailyHabit> result = this.dailyHabitService.createDailyHabit(data);
    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<DailyHabit> deleteById(@PathVariable Long id) {
    Optional<DailyHabit> result = this.dailyHabitService.deleteById(id);

    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PatchMapping("/{id}")
  public ResponseEntity<HashMap<String, DailyHabit>> updateDailyHabit(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody DailyHabitDTO data) {

    Optional<HashMap<String, DailyHabit>> result = this.dailyHabitService.updateDailyHabit(id, data);

    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
