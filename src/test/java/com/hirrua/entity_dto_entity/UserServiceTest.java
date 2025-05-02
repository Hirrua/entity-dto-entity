package com.hirrua.entity_dto_entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Deve retornar o usuário referente ao CPF")
    public void deveRetornarUmUsuarioComCpf() {
        String cpf = "12345678900";
        UserEntity userEntityMock = new UserEntity();
        userEntityMock.setCpf(cpf);
        userEntityMock.setNome("Nome Teste");
        userEntityMock.setSobrenome("Fulano Teste");
        userEntityMock.setEmail("fulanoteste@gmail.com");
        userEntityMock.setCelular("555555555");
        userEntityMock.setUserStatus(UserStatus.ACTIVE);

        when(userRepository.searchByDocument(cpf)).thenReturn(userEntityMock);

        UserDto resultado = userService.getByDocument(cpf);

        assertNotNull(resultado);
        assertEquals(cpf, resultado.cpf());
        assertEquals("555555555", resultado.celular());
        assertEquals("fulanoteste@gmail.com", resultado.email());
    }
}