package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.HashMap;

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
import com.fatec.cotia.projeto2.dsm2024.responses.StandardResponse;
import com.fatec.cotia.projeto2.dsm2024.services.ImpactPanelService;

@RestController
@RequestMapping("/impact_panel")
public class ImpactPanelController {
  @Autowired
  private ImpactPanelService impactPanelService;

  @GetMapping("/{id}")
  public ResponseEntity<StandardResponse<ImpactPanel>> findImpactPanelById(@PathVariable Long id) {
    ImpactPanel register = this.impactPanelService.findById(id);

    StandardResponse<ImpactPanel> response = new StandardResponse<>(register, "ImpactPanel criado com sucesso!");

    return ResponseEntity.ok(response);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<StandardResponse<HashMap<String, ImpactPanel>>> updateImpactPanelById(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody ImpactPanelDTO data) {

    HashMap<String, ImpactPanel> result = this.impactPanelService.updateImpactPanel(id, data);

    StandardResponse<HashMap<String, ImpactPanel>> response = new StandardResponse<>(result,
        "ImpactPanel atualizado com sucesso!");

    return ResponseEntity.ok(response);

  }
}
