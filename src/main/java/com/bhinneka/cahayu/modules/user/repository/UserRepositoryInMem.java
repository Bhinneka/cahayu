/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.repository;

import com.bhinneka.cahayu.modules.repository.BaseRepositoryInMem;
import com.bhinneka.cahayu.modules.user.model.User;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author wurianto
 */
public class UserRepositoryInMem extends BaseRepositoryInMem<User, ObjectId> implements IUserRepository {

    private final Map<ObjectId, User> db;

    public UserRepositoryInMem(Map<ObjectId, User> db) {
        super(db);
        this.db = db;
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        for (User u : this.db.values()) {
            if (u.getEmail().equals(email)) {
                user = u;
            }
        }
        return user;
    }

}
