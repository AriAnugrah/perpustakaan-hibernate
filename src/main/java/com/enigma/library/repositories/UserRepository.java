package com.enigma.library.repositories;

import com.enigma.library.entities.User;

import javax.persistence.EntityManager;

public class UserRepository extends AbstractRepository<Integer, User>{
public UserRepository(EntityManager entityManager) {
        super(entityManager, User.class);
        }
}
