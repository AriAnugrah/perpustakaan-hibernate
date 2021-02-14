package com.enigma.library.service;

import com.enigma.library.entities.Category;
import com.enigma.library.repositories.CategoryRepository;


import javax.persistence.EntityManager;

public class CategoryService extends AbstractService<Integer, Category>{
    public CategoryService(EntityManager entityManager, CategoryRepository repository) {
        super(entityManager, repository);
    }
}
