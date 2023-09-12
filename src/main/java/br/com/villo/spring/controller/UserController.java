package br.com.villo.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villo.spring.dto.CreateDepositDto;
import br.com.villo.spring.dto.UserDto;
import br.com.villo.spring.model.User;
import br.com.villo.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody final UserDto userData) {
    final User createdUser = userService.createUser(userData);

    return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<User>> readUsers() {
    final List<User> allUsers = userService.readUsers();

    return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> retrieveUser(@PathVariable String id) throws Exception {

    final User user = userService.retrieveUser(Long.parseLong(id));

    return new ResponseEntity<User>(user, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@RequestBody final UserDto userData, @PathVariable String id) throws Exception {

    final User updatedUser = userService.updateUser(userData, Long.parseLong(id));

    return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable String id) throws Exception {

    userService.deleteUser(Long.parseLong(id));

    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

  @PostMapping("/{id}/deposit")
  public ResponseEntity<User> updateUser(@RequestBody final CreateDepositDto depositData, @PathVariable String id) throws Exception {

    final User depositedUser = userService.createDeposit(depositData, Long.parseLong(id));

    return new ResponseEntity<User>(depositedUser, HttpStatus.CREATED);
  }
}
