/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wurianto
 * @param <T>
 * @param <K>
 */
public abstract class BaseRepositoryInMem<T extends Object, K> implements IBaseRepository<T, K> {

    private final Map<K, T> db;

    public BaseRepositoryInMem(Map<K, T> db) {
        this.db = db;
    }

    @Override
    public T save(T t) {
        return t;
    }

    @Override
    public T delete(K id) {
        T u = this.db.remove(id);
        return u;
    }

    @Override
    public T findById(K id) {
        return this.db.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(db.values());
    }

}
