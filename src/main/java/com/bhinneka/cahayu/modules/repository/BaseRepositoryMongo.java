/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.repository;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author wurianto
 * @param <T>
 * @param <K>
 */
public class BaseRepositoryMongo<T extends Object, K> implements IBaseRepository<T, K> {

    private final MongoCollection<T> collection;

    public BaseRepositoryMongo(MongoCollection<T> collection) {
        this.collection = collection;
    }

    @Override
    public T save(T t) {
        this.collection.insertOne(t);
        return t;
    }

    @Override
    public T findById(K id) {
        return this.collection.find(eq("_id", id)).first();
    }

    @Override
    public T delete(K id) {
        return this.collection.findOneAndDelete(eq("_id", id));
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        this.collection.find().forEach(new Consumer<T>() {
            @Override
            public void accept(T t) {
                list.add(t);
            }
        });
        return list;
    }

}
