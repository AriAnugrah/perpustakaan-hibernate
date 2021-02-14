package com.enigma.library.repositories;

import com.enigma.library.entities.Borrow;

import javax.persistence.EntityManager;

public class BorrowRepository extends AbstractRepository<Integer, Borrow>{
    public BorrowRepository(EntityManager entityManager) {
        super(entityManager, Borrow.class);
    }
}
