package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.CreateCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.FindCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.services.CommonUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class CommonUserController {

  @Autowired
  private CommonUserService commonUserService;

  @GetMapping("/{id}")
  public ResponseEntity<CommonUser> findUser(@PathVariable Long id) {

    FindCommonUserDTO userDTO = new FindCommonUserDTO();
    userDTO.setId(id);
    Optional<CommonUser> user = this.commonUserService.findById(userDTO);
    if (user.isPresent()) {
      return ResponseEntity.ok(user.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/")
  public ResponseEntity<CommonUser> createUser(@Valid @RequestBody CreateCommonUserDTO data) {
    Optional<CommonUser> newUser = this.commonUserService.createUser(data);

    if (newUser.isPresent()) {
      return ResponseEntity.status(HttpStatus.CREATED).body(newUser.get());
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
