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
package com.wuriyanto.cahayu.modules.repository;

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
