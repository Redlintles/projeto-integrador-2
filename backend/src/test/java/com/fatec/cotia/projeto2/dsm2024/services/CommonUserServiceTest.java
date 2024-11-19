
package com.fatec.cotia.projeto2.dsm2024.services;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fatec.cotia.projeto2.dsm2024.dtos.CommonUserDTO;
import com.fatec.cotia.projeto2.dsm2024.entities.CommonUser;
import com.fatec.cotia.projeto2.dsm2024.repositories.CommonUserRepository;

@ActiveProfiles("test")
@SpringBootTest
// @Transactional
public class CommonUserServiceTest {
  @Autowired
  private CommonUserService commonUserService;
  @Autowired
  CommonUserRepository commonUserRepository;

  @BeforeEach
  public void setUp() {
    this.commonUserRepository.deleteAll();
  }

  @Test
  public void testCreateUser() {
    CommonUserDTO userDTO = new CommonUserDTO();

    userDTO.setCpf("12345678910");
    userDTO.setEmail("user@example.com");
    userDTO.setEndereco("RUa Banana 321");
    userDTO.setHabitosDiarios((long) 3);
    userDTO.setMedalhas((long) 3);
    userDTO.setNome("Teste");
    userDTO.setSenha("Senha 123");
    userDTO.setPegadaCarbono((long) 2);

    Optional<HashMap<String, Object>> result = this.commonUserService.createUser(userDTO);

    assertTrue(result.isPresent());

    CommonUser savedUser = (CommonUser) result.get().get("User");

    assertNotNull(savedUser.getId());
    assertEquals(userDTO.getCpf(), savedUser.getCpf());
    assertEquals(userDTO.getEmail(), savedUser.getEmail());
    assertEquals(userDTO.getEndereco(), savedUser.getEndereco());
    assertEquals(userDTO.getHabitosDiarios(), savedUser.getHabitosDiarios());
    assertEquals(userDTO.getMedalhas(), savedUser.getMedalhas());
    assertEquals(userDTO.getNome(), savedUser.getNome());
    assertEquals(userDTO.getSenha(), savedUser.getSenha());
    assertEquals(userDTO.getPegadaCarbono(), savedUser.getPegadaCarbono());

  }

}
