/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.dto;

/**
 *
 * @author wurianto
 */
public class JwtDto {

    private String token;
    private UserDto userDto;

    public JwtDto() {

    }

    public JwtDto(String token, UserDto userDto) {
        this.token = token;
        this.userDto = userDto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "JwtDto{" + "token=" + token + ", userDto=" + userDto + '}';
    }

}
