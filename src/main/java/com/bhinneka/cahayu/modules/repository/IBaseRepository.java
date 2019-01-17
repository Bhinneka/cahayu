/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.repository;

import java.util.List;

/**
 *
 * @author wurianto
 *
 * @param <T>
 * @param <K>
 */
public interface IBaseRepository<T, K> {

    public T save(T t);

    public T findById(K id);

    public T delete(K id);

    public List<T> findAll();

}
