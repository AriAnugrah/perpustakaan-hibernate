package com.enigma.library.service;

import com.enigma.library.repositories.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class AbstractService<ID, T> implements Service<ID, T> {
    protected final EntityManager entityManager;
    protected final Repository<ID, T> repository;

    public AbstractService(EntityManager entityManager, Repository<ID, T> repository) {
        this.entityManager = entityManager;
        this.repository = repository;
    }

    public T save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            T savedEntity = repository.save(entity);
            transaction.commit();
            return savedEntity;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }


    @Override
    public T findById(ID id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            T entity = repository.findById(id);

            return entity;
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<T> findAll() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {

            List<T> entities = repository.findAll();

            return entities;
        } finally {
            transaction.commit();
        }
    }
}
