/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.filters;

import org.eclipse.jetty.http.HttpStatus;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 *
 * @author wurianto
 */
public class JwtFilters implements Filter{

    @Override
    public void handle(Request req, Response res) throws Exception {
        String authorization = req.headers("Authorization");
        if(authorization == null) {
            Spark.halt(HttpStatus.UNAUTHORIZED_401, "authorization is required");
        }
        System.out.println("AUTH : "+authorization);
    }
    
}
