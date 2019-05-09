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
package com.wuriyanto.cahayu.modules.user.usecase;

import com.wuriyanto.cahayu.jwt.CustomClaim;
import com.wuriyanto.cahayu.jwt.IJwtService;
import com.wuriyanto.cahayu.modules.user.model.Jwt;
import com.wuriyanto.cahayu.modules.user.model.User;
import com.wuriyanto.cahayu.modules.user.repository.IUserRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author wurianto
 */
public class UserUsecaseImpl implements IUserUsecase {

    private final IUserRepository userRepository;
    private final IJwtService jwtService;

    public UserUsecaseImpl(IUserRepository userRepository, IJwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public User createUser(User u) {
        return this.userRepository.save(u);
    }

    @Override
    public User updateUser(User u, ObjectId id) {
        User user = this.userRepository.findById(id);
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getFirstName());
        return user;
    }

    @Override
    public User me(ObjectId id) {
        return this.userRepository.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public Jwt login(User u) {
        Jwt result;
        User logged = this.userRepository.findByEmail(u.getEmail());
        if (logged == null || !logged.validatePassword(u.getPassword())) {
            result = null;
        } else {

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, Calendar.AUGUST);
            cal.set(Calendar.YEAR, 2019);
            cal.set(Calendar.DATE, 13);
            cal.set(Calendar.HOUR_OF_DAY, 17);
            cal.set(Calendar.MINUTE, 30);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            Date d = cal.getTime();
            String jwtToken = jwtService.generate(new CustomClaim(logged.getId().toString(), "bhinneka.com", "my-service", cal.getTime()));
            result = new Jwt("Bearer " + jwtToken);
        }
        return result;
    }

}
