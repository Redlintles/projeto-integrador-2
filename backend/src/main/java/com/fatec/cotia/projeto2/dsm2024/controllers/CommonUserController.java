package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cotia.projeto2.dsm2024.dtos.commonUser.FindCommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.services.CommonUserService;

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
}
