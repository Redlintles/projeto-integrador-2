package com.fatec.cotia.projeto2.dsm2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.cotia.projeto2.dsm2024.entities.Medal;

@Repository
public interface MedalRepository extends JpaRepository<Medal, Long> {

  public Medal findByNome(String nome);

}
