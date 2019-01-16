/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.jwt;

/**
 *
 * @author wurianto
 */
public interface IJwtService {

    public String generate(CustomClaim claim);
}
