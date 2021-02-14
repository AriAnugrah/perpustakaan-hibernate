package com.enigma.library.service;

import java.util.List;

public interface Service<ID, T> {

    T save(T entity);

    T findById(ID id);

    List<T> findAll();

}