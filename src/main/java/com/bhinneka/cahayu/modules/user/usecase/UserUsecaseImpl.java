/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.usecase;

import com.bhinneka.cahayu.modules.user.model.User;
import com.bhinneka.cahayu.modules.user.repository.IUserRepository;
import java.util.List;

/**
 *
 * @author wurianto
 */
public class UserUsecaseImpl implements IUserUsecase{
    
    private final IUserRepository userRepository;
    
    public UserUsecaseImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User u) {
        return this.userRepository.save(u);
    }

    @Override
    public User updateUser(User u, String id) {
        User user = this.userRepository.findById(id);
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getFirstName());
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }
    
}
