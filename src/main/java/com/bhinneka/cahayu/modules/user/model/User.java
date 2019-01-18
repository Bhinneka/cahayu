/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.model;

import com.bhinneka.cahayu.modules.user.dto.JwtDto;
import com.bhinneka.cahayu.modules.user.dto.UserDto;
import org.bson.types.ObjectId;

/**
 *
 * @author wurianto
 */
public class User {

    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(ObjectId id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public UserDto toDto() {
        return new UserDto(this.id.toString(), this.firstName, this.lastName, this.email, null);
    }

    public JwtDto toJwtDto(Jwt jwt) {
        return new JwtDto(jwt, new UserDto(this.id.toString(), this.firstName, this.lastName, this.email, null));
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + '}';
    }

}
