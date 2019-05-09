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
package com.wuriyanto.cahayu;

import com.wuriyanto.cahayu.database.MongoDb;
import com.wuriyanto.cahayu.modules.user.delivery.SparkHandler;
import com.wuriyanto.cahayu.modules.user.model.User;
import com.wuriyanto.cahayu.modules.user.repository.IUserRepository;
import com.wuriyanto.cahayu.modules.user.usecase.IUserUsecase;
import com.wuriyanto.cahayu.modules.user.usecase.UserUsecaseImpl;
import com.wuriyanto.cahayu.filters.Filters;
import com.wuriyanto.cahayu.filters.JwtFilters;
import com.wuriyanto.cahayu.jwt.IJwtService;
import com.wuriyanto.cahayu.jwt.JwtServiceImpl;
import com.wuriyanto.cahayu.modules.user.repository.UserRepositoryMongo;
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
    private String mongoDbConnectionString;
    private String mongoDbDatabaseName;
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
        MongoDatabase md = MongoDb.getDb(this.mongoDbConnectionString, this.mongoDbDatabaseName);
        MongoCollection<User> uc = md.getCollection(MongoDb.USERS_COLLECTION, User.class);

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

    public void setMongoDbConnectionString(String mongoDbConnectionString) {
        this.mongoDbConnectionString = mongoDbConnectionString;
    }

    public void setMongoDbDatabaseName(String mongoDbDatabaseName) {
        this.mongoDbDatabaseName = mongoDbDatabaseName;
    }

}
