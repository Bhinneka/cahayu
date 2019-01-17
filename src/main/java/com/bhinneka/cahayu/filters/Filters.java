/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.filters;

import spark.Filter;
import spark.Request;
import spark.Response;

/**
 *
 * @author wurianto
 */
public class Filters {
    
    public static Filter setJsonHeader() {
        return (Request req, Response res) -> {
          res.header("Content-Type", "application/json");  
        };
    }
}
