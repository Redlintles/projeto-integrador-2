package com.fatec.cotia.projeto2.dsm2024.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.cotia.projeto2.dsm2024.entities.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
  public void deleteByCreatedAtBefore(LocalDateTime dateTIme);

  public Optional<Token> findByCpf(String cpf);
}
