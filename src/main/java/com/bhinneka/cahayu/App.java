package com.bhinneka.cahayu;

import com.bhinneka.cahayu.modules.user.delivery.SparkHandler;
import com.bhinneka.cahayu.modules.user.model.User;
import com.bhinneka.cahayu.modules.user.repository.IUserRepository;
import com.bhinneka.cahayu.modules.user.repository.UserRepositoryInMem;
import com.bhinneka.cahayu.modules.user.usecase.IUserUsecase;
import com.bhinneka.cahayu.modules.user.usecase.UserUsecaseImpl;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.HashMap;
import java.util.Map;
import spark.Spark;

/**
 * created by Wuriyanto 16 01n2019
 *
 */
public class App {
    
    public static void main( String[] args ){
        Dotenv dotenv = Dotenv.load();
        int port = Integer.parseInt(dotenv.get("PORT"));
        
        //set custom port
        Spark.port(port);
        
        // user module
        Map<String, User> db = new HashMap<>();
        db.put("USR001", new User("USR001", "Wuriyanto", "Musobar", "wuriyanto@bhinneka.com"));
        db.put("USR002", new User("USR002", "James", "Gosling", "james@bhinneka.com"));
        
        IUserRepository userRepository = new UserRepositoryInMem(db);
        IUserUsecase userUsecase = new UserUsecaseImpl(userRepository);
        
        //user handler
        SparkHandler userSparkHandler = new SparkHandler(userUsecase);
        
        Spark.get("/", new IndexRoute());
        Spark.get("/users", userSparkHandler.index());
        Spark.post("/users", userSparkHandler.addUser());
        
    }
}
