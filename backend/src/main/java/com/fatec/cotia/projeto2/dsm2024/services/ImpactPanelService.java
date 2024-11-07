package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.impactPanel.CreateImpactPanelDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.repositories.ImpactPanelRepository;

@Service
public class ImpactPanelService {
  @Autowired
  private ImpactPanelRepository impactPanelRepository;

  public Optional<ImpactPanel> createImpactPanel(CreateImpactPanelDTO data) {
    ImpactPanel newPanel = new ImpactPanel();

    newPanel.setImpactoColetivo(data.getImpactoColetivo());
    newPanel.setImpactoIndividual(data.getImpactoIndividual());
    newPanel.setUsuario_cpf(data.getUsuario_cpf());

    newPanel = this.impactPanelRepository.save(newPanel);

    return Optional.of(newPanel);
  }

}
