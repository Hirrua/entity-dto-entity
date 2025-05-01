package com.hirrua.entity_dto_entity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        var user = userService.createAnUser(userDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{cpf}")
    public ResponseEntity<UserDto> getUserByDocument(@PathVariable(value = "cpf") String cpf) {
        var user = userService.getByDocument(cpf);
        return ResponseEntity.ok(user);
    }

}
