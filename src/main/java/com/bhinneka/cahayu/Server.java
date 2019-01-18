/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu;

import com.bhinneka.cahayu.database.MongoDb;
import com.bhinneka.cahayu.modules.user.delivery.SparkHandler;
import com.bhinneka.cahayu.modules.user.model.User;
import com.bhinneka.cahayu.modules.user.repository.IUserRepository;
import com.bhinneka.cahayu.modules.user.repository.UserRepositoryInMem;
import com.bhinneka.cahayu.modules.user.usecase.IUserUsecase;
import com.bhinneka.cahayu.modules.user.usecase.UserUsecaseImpl;
import com.bhinneka.cahayu.filters.Filters;
import com.bhinneka.cahayu.filters.JwtFilters;
import com.bhinneka.cahayu.jwt.IJwtService;
import com.bhinneka.cahayu.jwt.JwtServiceImpl;
import com.bhinneka.cahayu.modules.user.repository.UserRepositoryMongo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import org.bson.types.ObjectId;
import spark.Spark;

/**
 *
 * @author wurianto
 */
public class Server {

    private final int port;
    private final Key privateKey;
    private final Key publicKey;

    public Server(int port, Key privateKey, Key publicKey) {
        this.port = port;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public void start() {
        //set custom port
        Spark.port(port);

        // set filters
        Spark.notFound(new NotFoundRoute());

        // user module
        Map<ObjectId, User> userDb = new HashMap<>();
        userDb.put(new ObjectId("5c418087e86ddac693ffed90"), new User(new ObjectId("5c418087e86ddac693ffed90"), "Wuriyanto", "Musobar", "wuriyanto@bhinneka.com", "12345"));
        userDb.put(new ObjectId("5c418087e86ddac693ffed70"), new User(new ObjectId("5c418087e86ddac693ffed70"), "James", "Gosling", "james@bhinneka.com", "123456"));

        // mongodb
        MongoDatabase md = MongoDb.getDb("mongodb://127.0.0.1:27017/cahayu", "cahayu");
        MongoCollection<User> uc = md.getCollection("users", User.class);

        IJwtService jwtService = new JwtServiceImpl(this.privateKey, this.publicKey);

        IUserRepository userRepository = new UserRepositoryMongo(uc);
        IUserUsecase userUsecase = new UserUsecaseImpl(userRepository, jwtService);

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
