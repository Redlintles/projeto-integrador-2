package com.fatec.cotia.projeto2.dsm2024.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.entities.Token;
import com.fatec.cotia.projeto2.dsm2024.errors.EntityNotFoundException;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;
import com.fatec.cotia.projeto2.dsm2024.repositories.TokenRepository;

@Service
public class TokenService {
  @Autowired
  private TokenRepository tokenRepository;

  @Autowired
  CommonUserRepository commonUserRepository;

  @Scheduled(cron = "0 0 * * * ?")
  public void cleanupExpiredTokens() {
    LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);

    this.tokenRepository.deleteByCreatedAtBefore(oneHourAgo);
  }

  public boolean isValidToken(String token) {
    return this.tokenRepository.existsByToken(token);
  }

  public boolean isValidByCpf(String cpf) {
    return this.tokenRepository.existsByCpf(cpf);
  }

  public CommonUser findUserByToken(String token) {
    Optional<Token> entity = this.tokenRepository.findByToken(token);

    if (entity.isPresent()) {

      Optional<CommonUser> user = this.commonUserRepository.findByCpf(entity.get().getCpf());

      if (user.isPresent()) {
        return user.get();

      } else {
        throw new EntityNotFoundException("O usuário não foi encontrado");
      }
    } else {
      throw new EntityNotFoundException("O Token não foi encontrado");
    }
  }

}
