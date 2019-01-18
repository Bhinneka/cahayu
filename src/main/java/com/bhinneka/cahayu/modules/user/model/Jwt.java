/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.model;

/**
 *
 * @author wurianto
 */
public class Jwt {

    private String accessToken;

    public Jwt() {
    }

    public Jwt(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "Jwt{" + "accessToken=" + accessToken + '}';
    }

}
