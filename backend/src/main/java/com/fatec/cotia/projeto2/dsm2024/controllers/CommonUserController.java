package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cotia.projeto2.dsm2024.dtos.CommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.interfaces.CreationGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.interfaces.UpdateGroupInterface;
import com.fatec.cotia.projeto2.dsm2024.requests.LoginRequest;
import com.fatec.cotia.projeto2.dsm2024.services.CommonUserService;

@RestController
@RequestMapping("/user")
public class CommonUserController {

  @Autowired
  private CommonUserService commonUserService;

  @GetMapping("/{id}")
  public ResponseEntity<CommonUser> findUser(@PathVariable Long id) {

    Optional<CommonUser> user = this.commonUserService.findById(id);
    if (user.isPresent()) {
      return ResponseEntity.ok(user.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/login")
  public ResponseEntity<HashMap<String, Object>> loginUser(@RequestBody LoginRequest data) {
    Optional<HashMap<String, Object>> newToken = this.commonUserService.loginUser(data.getEmail(), data.getPassword());

    if (newToken.isPresent()) {
      return ResponseEntity.ok(newToken.get());
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping
  public ResponseEntity<HashMap<String, Object>> createUser(
      @Validated(CreationGroupInterface.class) @RequestBody CommonUserDTO data) {
    Optional<HashMap<String, Object>> newUser = this.commonUserService.createUser(data);

    if (newUser.isPresent()) {
      return ResponseEntity.status(HttpStatus.CREATED).body(newUser.get());
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PatchMapping("/{id}")
  public ResponseEntity<HashMap<String, CommonUser>> updateUser(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody CommonUserDTO data) {
    Optional<HashMap<String, CommonUser>> result = this.commonUserService.updateUser(id, data);

    System.out.println(String.format("\n\n%s\n\n", result.get().get("New").getId()));
    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CommonUser> deleteUser(@PathVariable Long id) {

    Optional<CommonUser> result = this.commonUserService.deleteUserById(id);

    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }

  }
}
