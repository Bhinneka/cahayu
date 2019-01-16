package com.bhinneka.cahayu;

import io.github.cdimascio.dotenv.Dotenv;


/**
 * created by Wuriyanto 16 01 2019
 *
 */
public class App {
    
    public static void main( String[] args ){
        Dotenv dotenv = Dotenv.load();
        int port = Integer.parseInt(dotenv.get("PORT"));
        
        Server server = new Server(port);
        server.start();
    }
}
