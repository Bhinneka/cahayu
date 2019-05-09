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

import java.util.List;

/**
 *
 * @author wurianto
 *
 * @param <T>
 * @param <K>
 */
public interface IBaseRepository<T extends Object, K> {

    public T save(T t);

    public T findById(K id);

    public T delete(K id);

    public List<T> findAll();

}
