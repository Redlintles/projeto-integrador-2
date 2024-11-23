package com.fatec.cotia.projeto2.dsm2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cotia.projeto2.dsm2024.responses.StandardResponse;
import com.fatec.cotia.projeto2.dsm2024.services.TokenService;

@RestController
@RequestMapping("/token")
public class TokenController {
  @Autowired
  private TokenService tokenService;

  @GetMapping("/valid/{token}")
  public ResponseEntity<StandardResponse<Boolean>> isValid(@PathVariable String token) {

    Boolean isValid = this.tokenService.isValidToken(token);
    StandardResponse<Boolean> response = new StandardResponse<>(isValid, "Token verificado com sucesso");

    return ResponseEntity.ok(response);

  }

  @GetMapping("/user/{cpf}")
  public ResponseEntity<StandardResponse<Boolean>> isValidByCpf(@PathVariable String cpf) {

    Boolean isValid = this.tokenService.isValidByCpf(cpf);
    StandardResponse<Boolean> response = new StandardResponse<>(isValid, "Token verificado com sucesso");

    return ResponseEntity.ok(response);

  }

}
