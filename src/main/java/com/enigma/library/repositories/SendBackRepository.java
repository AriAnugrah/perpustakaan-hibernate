package com.enigma.library.repositories;

import com.enigma.library.entities.SendBack;


import javax.persistence.EntityManager;

public class SendBackRepository extends AbstractRepository<Integer, SendBack> {
    public SendBackRepository(EntityManager entityManager) {
        super(entityManager, SendBack.class);
    }
}
