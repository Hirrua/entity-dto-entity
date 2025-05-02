package com.hirrua.entity_dto_entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {

    private final Logger log = LoggerFactory.getLogger(UserRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveUser(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Transactional
    public UserEntity searchByDocument(String cpf) {
        try {
            return entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.cpf = :cpf", UserEntity.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.warn("Nenhum UserEntity encontrado com o CPF: {}", cpf);
            return null;
        }
    }

    @Transactional
    public List<UserEntity> searchUserActive() {
        try {
            return entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.userStatus = :status", UserEntity.class)
                    .setParameter("status", UserStatus.ACTIVE)
                    .getResultList();
        } catch (NoResultException e) {
            log.warn("Não foram encontrado usuários ativos");
            return null;
        }
    }
}
