package com.fatec.cotia.projeto2.dsm2024.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;

public interface CommonUserRepository extends JpaRepository<CommonUser, Long> {
  public Optional<CommonUser> findByCpf(String cpf);

  public Optional<CommonUser> findByNome(String nome);

  public Optional<CommonUser> findByEmail(String email);
}
