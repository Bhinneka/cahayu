/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.usecase;

import com.bhinneka.cahayu.modules.user.model.User;
import java.util.List;

/**
 *
 * @author wurianto
 */
public interface IUserUsecase {
    
    public User createUser(User u);
    public User updateUser(User u, String id);
    public List<User> getAllUser();
    
}
