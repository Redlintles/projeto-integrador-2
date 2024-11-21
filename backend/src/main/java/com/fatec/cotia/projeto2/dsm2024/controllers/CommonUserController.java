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

    CommonUser user = this.commonUserService.findById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping("/login")
  public ResponseEntity<HashMap<String, Object>> loginUser(@RequestBody LoginRequest data) {
    HashMap<String, Object> newToken = this.commonUserService.loginUser(data.getEmail(), data.getPassword());

    return ResponseEntity.ok(newToken);
  }

  @PostMapping
  public ResponseEntity<HashMap<String, Object>> createUser(
      @Validated(CreationGroupInterface.class) @RequestBody CommonUserDTO data) {
    HashMap<String, Object> newUser = this.commonUserService.createUser(data);

    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<HashMap<String, CommonUser>> updateUser(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody CommonUserDTO data) {
    Optional<HashMap<String, CommonUser>> result = this.commonUserService.updateUser(id, data);

    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CommonUser> deleteUser(@PathVariable Long id) {
    CommonUser result = this.commonUserService.deleteUserById(id);

    return ResponseEntity.ok(result);

  }
}
