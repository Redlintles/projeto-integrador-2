package com.fatec.cotia.projeto2.dsm2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;

public interface CommonUserRepository extends JpaRepository<CommonUser, Long> {
  public CommonUser findByidCPF(Long idCPF);

  public CommonUser findByNome(String nome);

  public CommonUser findByEmail(String email);
}
