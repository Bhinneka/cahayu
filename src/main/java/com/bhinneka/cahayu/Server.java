/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu;

import com.bhinneka.cahayu.modules.user.delivery.SparkHandler;
import com.bhinneka.cahayu.modules.user.model.User;
import com.bhinneka.cahayu.modules.user.repository.IUserRepository;
import com.bhinneka.cahayu.modules.user.repository.UserRepositoryInMem;
import com.bhinneka.cahayu.modules.user.usecase.IUserUsecase;
import com.bhinneka.cahayu.modules.user.usecase.UserUsecaseImpl;
import com.bhinneka.cahayu.filters.Filters;
import com.bhinneka.cahayu.filters.JwtFilters;
import java.util.HashMap;
import java.util.Map;
import spark.Spark;

/**
 *
 * @author wurianto
 */
public class Server {

    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        //set custom port
        Spark.port(port);

        // set filters
        Spark.notFound(new NotFoundRoute());

        // user module
        Map<String, User> userDb = new HashMap<>();
        userDb.put("USR001", new User("USR001", "Wuriyanto", "Musobar", "wuriyanto@bhinneka.com"));
        userDb.put("USR002", new User("USR002", "James", "Gosling", "james@bhinneka.com"));

        IUserRepository userRepository = new UserRepositoryInMem(userDb);
        IUserUsecase userUsecase = new UserUsecaseImpl(userRepository);

        //user handler
        SparkHandler userSparkHandler = new SparkHandler(userUsecase);

        Spark.get("/", new IndexRoute());

        // path api
        Spark.path("/api", () -> {
            Spark.before("/*", Filters.setJsonHeader());
            Spark.before("/users/me", new JwtFilters());

            Spark.path("/users", userSparkHandler);
        });
    }

}
