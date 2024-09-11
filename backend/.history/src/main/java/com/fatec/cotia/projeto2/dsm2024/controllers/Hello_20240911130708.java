package com.fatec.cotia.projeto2.dsm2024.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController()
@RequestMapping("/api")
public class Hello {
  @GetMapping("hello")
  public String hello() {

    return "Hello World!";
  }
}
