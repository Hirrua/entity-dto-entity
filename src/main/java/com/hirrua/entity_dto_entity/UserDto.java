package com.hirrua.entity_dto_entity;

public record UserDto(String nome, String sobrenome, String email, String cpf, String celular, UserStatus userStatus) {
}
