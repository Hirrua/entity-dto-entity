package com.hirrua.entity_dto_entity;

import jakarta.validation.Valid;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        try {
            var user = userService.createAnUser(userDto);
            return ResponseEntity.ok(user);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getUsersIsActive() {
        return ResponseEntity.ok(userService.getUsersActive());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UserDto> getUserByDocument(@PathVariable(value = "cpf") String cpf) {
        var user = userService.getByDocument(cpf);
        return ResponseEntity.ok(user);
    }

}
