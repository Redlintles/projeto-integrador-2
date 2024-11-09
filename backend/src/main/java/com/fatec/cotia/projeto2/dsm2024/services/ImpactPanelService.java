package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.ImpactPanelDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.repositories.ImpactPanelRepository;

@Service
public class ImpactPanelService {
  @Autowired
  private ImpactPanelRepository impactPanelRepository;

  public Optional<ImpactPanel> createImpactPanel(ImpactPanelDTO data) {
    ImpactPanel newPanel = new ImpactPanel();

    newPanel.setImpactoColetivo(data.getImpactoColetivo());
    newPanel.setImpactoIndividual(data.getImpactoIndividual());

    newPanel = this.impactPanelRepository.save(newPanel);

    return Optional.of(newPanel);
  }

  public Optional<ImpactPanel> findById(Long id) {
    return this.impactPanelRepository.findById(id);
  }

  public Optional<HashMap<String, ImpactPanel>> updateImpactPanel(Long id, ImpactPanelDTO data) {
    Optional<ImpactPanel> toUpdate = this.impactPanelRepository.findById(id);

    if (toUpdate.isEmpty()) {
      return null;
    }

    HashMap<String, ImpactPanel> returnResult = new HashMap<>();

    returnResult.put("Old", toUpdate.get());

    ImpactPanel copy = new ImpactPanel(toUpdate.get());

    if (data.getImpactoColetivo() != null) {
      copy.setImpactoColetivo(data.getImpactoColetivo());
    }

    if (data.getImpactoIndividual() != null) {
      copy.setImpactoIndividual(data.getImpactoIndividual());
    }

    ImpactPanel updatedImpactPanel = this.impactPanelRepository.save(copy);

    returnResult.put("New", updatedImpactPanel);

    return Optional.of(returnResult);

  }

  public Optional<ImpactPanel> deleteById(Long id) {
    Optional<ImpactPanel> toDelete = this.impactPanelRepository.findById(id);

    if (toDelete.isEmpty()) {
      return null;
    } else {
      this.impactPanelRepository.deleteById(id);
      return toDelete;
    }
  }
}
