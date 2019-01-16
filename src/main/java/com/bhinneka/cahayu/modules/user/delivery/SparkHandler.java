/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.delivery;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author wurianto
 */
public class SparkHandler {
    
    public static Route index = (Request req, Response res) -> {
        return "index";
    };
    
}
