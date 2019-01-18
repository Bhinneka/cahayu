/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.dto;

import com.bhinneka.cahayu.modules.user.model.Jwt;
import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 * @author wurianto
 */
public class JwtDto {

    private Jwt jwt;
    private UserDto userDto;

    public JwtDto() {

    }

    public JwtDto(Jwt jwt, UserDto userDto) {
        this.jwt = jwt;
        this.userDto = userDto;
    }

    public Jwt getJwt() {
        return jwt;
    }

    public void setJwt(Jwt jwt) {
        this.jwt = jwt;
    }

    @JsonGetter("user")
    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "JwtDto{" + "jwt=" + jwt + ", userDto=" + userDto + '}';
    }

}
