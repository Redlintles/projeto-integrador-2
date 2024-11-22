package com.fatec.cotia.projeto2.dsm2024.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fatec.cotia.projeto2.dsm2024.repositories.TokenRepository;

@Service
public class TokenService {
  @Autowired
  private TokenRepository tokenRepository;

  @Scheduled(cron = "0 0 * * * ?")
  public void cleanupExpiredTokens() {
    LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);

    this.tokenRepository.deleteByCreatedAtBefore(oneHourAgo);
  }

  public boolean isValidToken(String token) {
    return this.tokenRepository.existsByToken(token);
  }
}
