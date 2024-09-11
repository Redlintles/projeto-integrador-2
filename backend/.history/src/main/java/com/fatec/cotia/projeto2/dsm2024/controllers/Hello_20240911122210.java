package com.fatec.cotia.projeto2.dsm2024.controllers;

import org.springframework.web.bind.annotation.GetMapping;


public class Hello {
  @GetMapping("hello")
  public String hello() {
    return "Hello World";
  }
}
