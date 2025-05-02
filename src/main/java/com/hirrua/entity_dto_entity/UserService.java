package com.hirrua.entity_dto_entity;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createAnUser(UserDto userDto) {
        var user = toEntity(userDto);
        System.out.println(user);
        userRepository.saveUser(user);
        return userDto;
    }

    public UserDto getByDocument(String cpf) {
        var userFind = userRepository.searchByDocument(cpf);
        return toDto(userFind);
    }

    public List<UserDto> getUsersActive() {
        var users = userRepository.searchUserActive();
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private UserEntity toEntity(UserDto userDto) {
        return new UserEntity(
                userDto.nome(),
                userDto.sobrenome(),
                userDto.email(),
                userDto.cpf(),
                userDto.celular(),
                userDto.userStatus()
        );
    }

    private UserDto toDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getNome(),
                userEntity.getSobrenome(),
                userEntity.getEmail(),
                userEntity.getCpf(),
                userEntity.getCelular(),
                userEntity.getUserStatus()
        );
    }
}
