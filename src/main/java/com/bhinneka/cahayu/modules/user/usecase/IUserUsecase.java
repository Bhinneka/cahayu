/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.usecase;

import com.bhinneka.cahayu.modules.user.model.Jwt;
import com.bhinneka.cahayu.modules.user.model.User;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author wurianto
 */
public interface IUserUsecase {

    public User createUser(User u);

    public User updateUser(User u, ObjectId id);

    public Jwt login(User u);

    public User me(ObjectId id);

    public List<User> getAllUser();

}
