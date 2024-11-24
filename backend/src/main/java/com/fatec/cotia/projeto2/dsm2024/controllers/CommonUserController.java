package com.fatec.cotia.projeto2.dsm2024.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
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
import com.fatec.cotia.projeto2.dsm2024.responses.StandardResponse;
import com.fatec.cotia.projeto2.dsm2024.services.CommonUserService;

@RestController
@RequestMapping("/user")
public class CommonUserController {

  @Autowired
  private CommonUserService commonUserService;

  @GetMapping("/{id}")
  public ResponseEntity<StandardResponse<CommonUser>> findUser(@PathVariable Long id) {

    CommonUser user = this.commonUserService.findById(id);

    StandardResponse<CommonUser> response = new StandardResponse<>(user, "Usuário encontrado com sucesso");

    return ResponseEntity.ok(response);
  }

  @PostMapping("/login")
  public ResponseEntity<StandardResponse<HashMap<String, Object>>> loginUser(@RequestBody LoginRequest data) {
    HashMap<String, Object> newToken = this.commonUserService.loginUser(data.getEmail(), data.getPassword());

    ResponseCookie cookie = ResponseCookie.from("user", newToken.get("token").toString()).httpOnly(false).path("/")
        .maxAge(60 * 60).build();

    HttpHeaders headers = new HttpHeaders();

    headers.add(HttpHeaders.SET_COOKIE, cookie.toString());

    StandardResponse<HashMap<String, Object>> response = new StandardResponse<>(newToken,
        "Usuário logado com sucesso!");

    return ResponseEntity.ok().headers(headers).body(response);
  }

  @PostMapping
  public ResponseEntity<StandardResponse<HashMap<String, Object>>> createUser(
      @Validated(CreationGroupInterface.class) @RequestBody CommonUserDTO data) {
    HashMap<String, Object> newUser = this.commonUserService.createUser(data);

    ResponseCookie cookie = ResponseCookie.from("user", newUser.get("token").toString()).httpOnly(false).path("/")
        .maxAge(60 * 60).build();

    HttpHeaders headers = new HttpHeaders();

    headers.add(HttpHeaders.SET_COOKIE, cookie.toString());

    StandardResponse<HashMap<String, Object>> response = new StandardResponse<>(newUser,
        "Usuário criado com sucesso!");

    return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(response);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<StandardResponse<HashMap<String, CommonUser>>> updateUser(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody CommonUserDTO data) {
    HashMap<String, CommonUser> result = this.commonUserService.updateUser(id, data);

    StandardResponse<HashMap<String, CommonUser>> response = new StandardResponse<>(result,
        "Usuário atualizado com sucesso!");
    return ResponseEntity.ok(response);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<StandardResponse<CommonUser>> deleteUser(@PathVariable Long id) {
    CommonUser result = this.commonUserService.deleteUserById(id);

    StandardResponse<CommonUser> response = new StandardResponse<>(result, "Usuário excluído com sucesso!");

    return ResponseEntity.ok(response);

  }
}
