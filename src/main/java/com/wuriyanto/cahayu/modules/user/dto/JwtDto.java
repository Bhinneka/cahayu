/*
 * Copyright 2019 wuriyanto.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wuriyanto.cahayu.modules.user.dto;

import com.wuriyanto.cahayu.modules.user.model.Jwt;
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
