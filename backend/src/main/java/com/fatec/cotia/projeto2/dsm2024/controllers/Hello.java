package com.fatec.cotia.projeto2.dsm2024.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cotia.projeto2.dsm2024.responses.StandardResponse;

@RestController()
public class Hello {
  @GetMapping("hello")
  public ResponseEntity<StandardResponse<String>> hello() {

    StandardResponse<String> response = new StandardResponse<>("Hello World!", "Server is up and running!");

    return ResponseEntity.ok(response);
  }
}
