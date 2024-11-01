package com.fatec.cotia.projeto2.dsm2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.cotia.projeto2.dsm2024.entities.Medal;

public interface MedalRepository extends JpaRepository<Medal, Long> {
  public Medal findByIdMedalha(Long idMedalha);

  public Medal findByNome(Long nome);

}
