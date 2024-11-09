package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cotia.projeto2.dsm2024.dtos.ImpactPanelDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.interfaces.UpdateGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.services.ImpactPanelService;

@RestController
@RequestMapping("/impact_panel")
public class ImpactPanelController {
  @Autowired
  private ImpactPanelService impactPanelService;

  @GetMapping("/{id}")
  public ResponseEntity<ImpactPanel> findImpactPanelById(@PathVariable Long id) {
    Optional<ImpactPanel> register = this.impactPanelService.findById(id);

    if (register.isPresent()) {
      return ResponseEntity.ok(register.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PatchMapping("/{id}")
  public ResponseEntity<HashMap<String, ImpactPanel>> updateImpactPanelById(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody ImpactPanelDTO data) {

    Optional<HashMap<String, ImpactPanel>> result = this.impactPanelService.updateImpactPanel(id, data);
    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }

  }
}
