package com.enigma.library.repositories;

import java.util.List;

public interface Repository<ID, T> {

    T save(T entity);


    T findById(ID id);

    List<T> findAll();

}
