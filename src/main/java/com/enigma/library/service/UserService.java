package com.enigma.library.service;

import com.enigma.library.entities.User;
import com.enigma.library.repositories.UserRepository;

import javax.persistence.EntityManager;

public class UserService extends AbstractService<Integer, User> {

    public UserService(EntityManager entityManager, UserRepository repository) {
        super(entityManager, repository);
    }
}
