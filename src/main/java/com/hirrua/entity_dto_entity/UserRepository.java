package com.hirrua.entity_dto_entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveUser(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }
}
