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

import com.fatec.cotia.projeto2.dsm2024.dtos.DailyHabitDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.DailyHabit;
import com.fatec.cotia.projeto2.dsm2024.interfaces.CreationGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.interfaces.UpdateGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.responses.StandardResponse;
import com.fatec.cotia.projeto2.dsm2024.services.DailyHabitService;

@RestController
@RequestMapping("/daily_habit")
public class DailyHabitController {
  @Autowired
  private DailyHabitService dailyHabitService;

  @GetMapping("/{id}")
  public ResponseEntity<StandardResponse<DailyHabit>> findDailyHabit(@PathVariable Long id) {
    DailyHabit result = this.dailyHabitService.findById(id);

    StandardResponse<DailyHabit> response = new StandardResponse<>(result, "Hábito encontrado com sucesso!");

    return ResponseEntity.ok(response);

  }

  @PostMapping
  public ResponseEntity<StandardResponse<DailyHabit>> createDailyHabit(
      @Validated(CreationGroupInterface.class) @RequestBody DailyHabitDTO data) {

    DailyHabit result = this.dailyHabitService.createDailyHabit(data);

    StandardResponse<DailyHabit> response = new StandardResponse<>(result, "Hábito criado com sucesso");

    return ResponseEntity.ok(response);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<StandardResponse<DailyHabit>> deleteById(@PathVariable Long id) {
    DailyHabit result = this.dailyHabitService.deleteById(id);

    StandardResponse<DailyHabit> response = new StandardResponse<>(result, "Hábito deletado com sucesso");

    return ResponseEntity.ok(response);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<StandardResponse<HashMap<String, DailyHabit>>> updateDailyHabit(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody DailyHabitDTO data) {

    HashMap<String, DailyHabit> result = this.dailyHabitService.updateDailyHabit(id, data);

    StandardResponse<HashMap<String, DailyHabit>> response = new StandardResponse<>(result,
        "Hábito atualizado com sucesso");

    return ResponseEntity.ok(response);

  }
}
