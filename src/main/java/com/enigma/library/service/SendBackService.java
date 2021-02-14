package com.enigma.library.service;

import com.enigma.library.entities.SendBack;
import com.enigma.library.repositories.SendBackRepository;

import javax.persistence.EntityManager;

public class SendBackService extends AbstractService<Integer, SendBack>{
    public SendBackService(EntityManager entityManager, SendBackRepository repository) {
        super(entityManager, repository);
    }
}
