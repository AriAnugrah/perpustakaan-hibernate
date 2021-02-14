package com.enigma.library.repositories;

import com.enigma.library.entities.Category;

import javax.persistence.EntityManager;

public class CategoryRepository extends AbstractRepository<Integer, Category>{
    public CategoryRepository(EntityManager entityManager) {
        super(entityManager, Category.class);
    }
}
