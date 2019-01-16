/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author wurianto
 */
public class IndexRoute implements Route{

    @Override
    public Object handle(Request req, Response res) throws Exception {
        return "i am up";
    }
    
}
