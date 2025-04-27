package com.hirrua.entity_dto_entity;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createAnUser(UserEntity userEntity) {
        var user = toDto(userEntity);
        userRepository.saveUser(userEntity);
        return user;
    }

    private UserDto toDto(UserEntity userEntity) {
        return new UserDto(userEntity.getNome(),
                userEntity.getSobrenome(),
                userEntity.getEmail(),
                userEntity.getCpf(),
                userEntity.getCelular(),
                userEntity.getUserStatus()
        );
    }
}
