package com.enigma.library.repositories;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractRepository<ID, T> implements Repository<ID, T> {

    protected final EntityManager entityManager;
    protected final Class<T> entityClass;

    public AbstractRepository(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;

    }

    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T removeById(ID id) {
        T entity = findById(id);
        entityManager.remove(entity);
        return entity;

    }

    public T findById(ID id) {
        return entityManager.find(entityClass, id);

    }

    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(entityClass);
        criteria.from(entityClass);
        return entityManager.createQuery(criteria).getResultList();
    }


}