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
import com.bhinneka.cahayu.shared.JsonUtil;

/**
 *
 * @author wurianto
 */
public class SparkHandler {
    
    private final IUserUsecase userUsecase;
    
    public SparkHandler(IUserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }
    
    public Route index() {
        return (Request req, Response res) -> {
            res.status(200);
            res.header("Content-Type", "application/json");
            return JsonUtil.dataToJson(userUsecase.getAllUser());
        };
    }
    
    
}
