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
package com.bhinneka.cahayu.modules.user.repository;

import com.bhinneka.cahayu.modules.repository.BaseRepositoryMongo;
import com.bhinneka.cahayu.modules.user.model.User;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author wurianto
 */
public class UserRepositoryMongo extends BaseRepositoryMongo<User, ObjectId> implements IUserRepository {

    private final MongoCollection<User> collection;

    public UserRepositoryMongo(MongoCollection<User> collection) {
        super(collection);
        this.collection = collection;
    }

    @Override
    public User findByEmail(String email) {
        return this.collection.find(eq("email", email)).first();
    }

}
