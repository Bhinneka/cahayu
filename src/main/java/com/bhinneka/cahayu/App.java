package com.bhinneka.cahayu;

import io.github.cdimascio.dotenv.Dotenv;
import spark.Spark;

/**
 * created by Wuriyanto 16 01n2019
 *
 */
public class App {
    
    public static void main( String[] args ){
        Dotenv dotenv = Dotenv.load();
        System.out.println(dotenv.get("PORT"));
        
        Spark.get("/", new IndexRoute());
    }
}
