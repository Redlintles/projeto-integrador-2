package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.dtos.ImpactPanelDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.ImpactPanel;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityCouldNotBeCreatedException;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityNotFoundException;
import com.fatec.cotia.projeto2.dsm2024.repositories.ImpactPanelRepository;

@Service
public class ImpactPanelService {
  @Autowired
  private ImpactPanelRepository impactPanelRepository;

  public ImpactPanel createImpactPanel(ImpactPanelDTO data) throws EntityCouldNotBeCreatedException {
    ImpactPanel newPanel = new ImpactPanel();

    newPanel.setImpactoColetivo(data.getImpactoColetivo());
    newPanel.setImpactoIndividual(data.getImpactoIndividual());
    newPanel = this.impactPanelRepository.save(newPanel);

    Optional<ImpactPanel> isSaved = this.impactPanelRepository.findById(newPanel.getId());

    if (isSaved.isEmpty()) {
      throw new EntityCouldNotBeCreatedException("Entidade não pode ser criada");
    }

    return newPanel;
  }

  public ImpactPanel findById(Long id) throws EntityNotFoundException {

    Optional<ImpactPanel> entity = this.impactPanelRepository.findById(id);

    if (entity.isPresent()) {
      return entity.get();
    } else {
      throw new EntityNotFoundException("Entidade Não pode ser encontrada");
    }

  }

  public HashMap<String, ImpactPanel> updateImpactPanel(Long id, ImpactPanelDTO data) throws EntityNotFoundException {
    Optional<ImpactPanel> toUpdate = this.impactPanelRepository.findById(id);

    if (toUpdate.isEmpty()) {
      throw new EntityNotFoundException("A entidade não pode ser encontrada para ser atualizada");
    }

    HashMap<String, ImpactPanel> returnResult = new HashMap<>();

    returnResult.put("Old", new ImpactPanel(toUpdate.get()));

    ImpactPanel copy = new ImpactPanel(toUpdate.get());

    if (data.getImpactoColetivo() != null) {
      copy.setImpactoColetivo(data.getImpactoColetivo());
    }

    if (data.getImpactoIndividual() != null) {
      copy.setImpactoIndividual(data.getImpactoIndividual());
    }

    ImpactPanel updatedImpactPanel = this.impactPanelRepository.save(copy);

    returnResult.put("New", updatedImpactPanel);

    return returnResult;

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
