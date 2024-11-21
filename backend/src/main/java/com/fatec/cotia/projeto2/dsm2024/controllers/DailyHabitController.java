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
import com.fatec.cotia.projeto2.dsm2024.services.DailyHabitService;

@RestController
@RequestMapping("/daily_habit")
public class DailyHabitController {
  @Autowired
  private DailyHabitService dailyHabitService;

  @GetMapping("/{id}")
  public ResponseEntity<DailyHabit> findDailyHabit(@PathVariable Long id) {
    DailyHabit result = this.dailyHabitService.findById(id);

    return ResponseEntity.ok(result);

  }

  @PostMapping
  public ResponseEntity<DailyHabit> createDailyHabit(
      @Validated(CreationGroupInterface.class) @RequestBody DailyHabitDTO data) {

    DailyHabit result = this.dailyHabitService.createDailyHabit(data);
    return ResponseEntity.ok(result);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<DailyHabit> deleteById(@PathVariable Long id) {
    DailyHabit result = this.dailyHabitService.deleteById(id);

    return ResponseEntity.ok(result);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<HashMap<String, DailyHabit>> updateDailyHabit(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody DailyHabitDTO data) {

    HashMap<String, DailyHabit> result = this.dailyHabitService.updateDailyHabit(id, data);

    return ResponseEntity.ok(result);

  }
}
