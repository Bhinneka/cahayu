/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.repository;

import com.bhinneka.cahayu.modules.user.model.User;
import java.util.List;

/**
 *
 * @author wurianto
 */
public interface IUserRepository {
    
    public User save(User u);
    public User findById(String id);
    public User findByEmail(String email);
    public List<User> findAll();
    
}
