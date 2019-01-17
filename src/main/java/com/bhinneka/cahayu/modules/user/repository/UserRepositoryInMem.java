/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.repository;

import com.bhinneka.cahayu.modules.user.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wurianto
 */
public class UserRepositoryInMem implements IUserRepository {

    private final Map<String, User> db;

    public UserRepositoryInMem(Map<String, User> db) {
        this.db = db;
    }

    @Override
    public User save(User u) {
        this.db.put(u.getId(), u);
        return u;
    }

    @Override
    public User delete(String id) {
        User u = this.db.remove(id);
        return u;
    }

    @Override
    public User findById(String id) {
        return this.db.get(id);
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

    @Override
    public List<User> findAll() {
        return new ArrayList<>(db.values());
    }

}
