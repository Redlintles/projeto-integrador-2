package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;

public class CommonUserService {
  @Autowired
  private CommonUserRepository commonUserRepository;

  public Optional<CommonUser> findById(long id) {
    return this.commonUserRepository.findById(id);
  }

}
