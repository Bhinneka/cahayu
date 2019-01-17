/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.repository;

import com.bhinneka.cahayu.modules.user.model.User;
import com.bhinneka.cahayu.modules.repository.IBaseRepository;

/**
 *
 * @author wurianto
 */
public interface IUserRepository extends IBaseRepository<User, String> {

    public User findByEmail(String email);

}
