/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.delivery;

import com.bhinneka.cahayu.modules.user.model.User;
import spark.Request;
import spark.Response;
import spark.Route;
import com.bhinneka.cahayu.modules.user.usecase.IUserUsecase;
import com.bhinneka.cahayu.shared.JsonUtil;
import org.eclipse.jetty.http.HttpStatus;

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
            res.status(HttpStatus.OK_200);

            return JsonUtil.dataToJson(userUsecase.getAllUser());
        };
    }
    
    public Route me() {
        return (Request req, Response res) -> {
            res.status(HttpStatus.OK_200);

            return "me";
        };
    }

    public Route addUser() {
        return (Request req, Response res) -> {
            res.status(HttpStatus.CREATED_201);

            byte[] body = req.bodyAsBytes();
            User u = JsonUtil.jsonToData(User.class, body);
            this.userUsecase.createUser(u);
            return JsonUtil.dataToJson(u);
        };
    }
    
    

}
