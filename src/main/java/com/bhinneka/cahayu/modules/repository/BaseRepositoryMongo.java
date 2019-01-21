/*
 * Copyright 2019 wuriyanto.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bhinneka.cahayu.modules.repository;

import com.mongodb.client.MongoCollection;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author wurianto
 * @param <T>
 * @param <K>
 */
public abstract class BaseRepositoryMongo<T extends Object, K> implements IBaseRepository<T, K> {

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
