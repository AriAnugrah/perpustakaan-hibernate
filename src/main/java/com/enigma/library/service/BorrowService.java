package com.enigma.library.service;

import com.enigma.library.entities.Borrow;
import com.enigma.library.repositories.BorrowRepository;


import javax.persistence.EntityManager;

public class BorrowService extends AbstractService<Integer, Borrow>{
    public BorrowService(EntityManager entityManager, BorrowRepository repository) {
        super(entityManager, repository);
    }
}
