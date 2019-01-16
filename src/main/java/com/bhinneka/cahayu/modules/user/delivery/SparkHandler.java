/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.delivery;

import spark.Request;
import spark.Response;
import spark.Route;
import com.bhinneka.cahayu.modules.user.usecase.IUserUsecase;

/**
 *
 * @author wurianto
 */
public class SparkHandler {
    
    private final IUserUsecase userUsecase;
    
    public SparkHandler(IUserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }
    
    public Route index = (Request req, Response res) -> {
        return "index";
    };
    
}
