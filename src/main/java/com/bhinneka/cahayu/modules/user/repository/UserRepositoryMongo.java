/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.repository;

import com.bhinneka.cahayu.modules.repository.BaseRepositoryMongo;
import com.bhinneka.cahayu.modules.user.model.User;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import org.bson.types.ObjectId;

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
