package com.enigma.library.repositories;

import com.enigma.library.entities.BukuKita;


import javax.persistence.EntityManager;

public class BukuKitaRepository extends AbstractRepository<Integer, BukuKita>{
    public BukuKitaRepository(EntityManager entityManager) {
        super(entityManager, BukuKita.class);
    }
}
