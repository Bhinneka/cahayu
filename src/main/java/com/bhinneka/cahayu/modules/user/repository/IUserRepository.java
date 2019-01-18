/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.repository;

import com.bhinneka.cahayu.modules.user.model.User;
import com.bhinneka.cahayu.modules.repository.IBaseRepository;
import org.bson.types.ObjectId;

/**
 *
 * @author wurianto
 */
public interface IUserRepository extends IBaseRepository<User, ObjectId> {

    public User findByEmail(String email);

}
