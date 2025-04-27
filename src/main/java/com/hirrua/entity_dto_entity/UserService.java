package com.hirrua.entity_dto_entity;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createAnUser(UserDto userDto) {
        var user = toEntity(userDto);
        userRepository.saveUser(user);
        return userDto;
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
}
