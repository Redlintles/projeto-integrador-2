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

    ResponseCookie cookie = ResponseCookie.from("user", newToken.get("token").toString()).httpOnly(true).path("/")
        .maxAge(60 * 60).build();

    HttpHeaders headers = new HttpHeaders();

    headers.add(HttpHeaders.SET_COOKIE, cookie.toString());

    return ResponseEntity.ok().headers(headers).body(newToken);
  }

  @PostMapping
  public ResponseEntity<HashMap<String, Object>> createUser(
      @Validated(CreationGroupInterface.class) @RequestBody CommonUserDTO data) {
    HashMap<String, Object> newUser = this.commonUserService.createUser(data);

    ResponseCookie cookie = ResponseCookie.from("user", newUser.get("token").toString()).httpOnly(true).path("/")
        .maxAge(60 * 60).build();

    HttpHeaders headers = new HttpHeaders();

    headers.add(HttpHeaders.SET_COOKIE, cookie.toString());

    return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newUser);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<HashMap<String, CommonUser>> updateUser(@PathVariable Long id,
      @Validated(UpdateGroupInterface.class) @RequestBody CommonUserDTO data) {
    HashMap<String, CommonUser> result = this.commonUserService.updateUser(id, data);

    return ResponseEntity.ok(result);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CommonUser> deleteUser(@PathVariable Long id) {
    CommonUser result = this.commonUserService.deleteUserById(id);

    return ResponseEntity.ok(result);

  }
}
