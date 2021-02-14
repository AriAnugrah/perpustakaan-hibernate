package com.enigma.library.service;

import com.enigma.library.entities.BukuKita;
import com.enigma.library.repositories.BukuKitaRepository;


import javax.persistence.EntityManager;

public class BukuKitaService extends AbstractService<Integer, BukuKita>{
    public BukuKitaService(EntityManager entityManager, BukuKitaRepository repository) {
        super(entityManager, repository);
    }
}
