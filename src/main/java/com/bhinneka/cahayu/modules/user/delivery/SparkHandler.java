/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.modules.user.delivery;

import com.bhinneka.cahayu.CustomResponse;
import com.bhinneka.cahayu.shared.EmptyJson;
import com.bhinneka.cahayu.modules.user.dto.UserDto;
import com.bhinneka.cahayu.modules.user.model.Jwt;
import com.bhinneka.cahayu.modules.user.model.User;
import spark.Request;
import spark.Response;
import spark.Route;
import com.bhinneka.cahayu.modules.user.usecase.IUserUsecase;
import com.bhinneka.cahayu.shared.JsonUtil;
import org.bson.types.ObjectId;
import org.eclipse.jetty.http.HttpStatus;
import spark.RouteGroup;
import spark.Spark;

/**
 *
 * @author wurianto
 */
public class SparkHandler implements RouteGroup {

    private final IUserUsecase userUsecase;

    public SparkHandler(IUserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    public Route index() {
        return (Request req, Response res) -> {
            res.status(HttpStatus.OK_200);

            return JsonUtil.dataToJson(new CustomResponse(
                    HttpStatus.OK_200, true, this.userUsecase.getAllUser(), "get all users"));
        };
    }

    public Route me() {
        return (Request req, Response res) -> {
            res.status(HttpStatus.OK_200);

            User u = this.userUsecase.me(new ObjectId("5c418087e86ddac693ffed90"));

            return JsonUtil.dataToJson(new CustomResponse(
                    HttpStatus.OK_200, true, u, "its me"));
        };
    }

    public Route addUser() {
        return (Request req, Response res) -> {
            res.status(HttpStatus.CREATED_201);

            byte[] body = req.bodyAsBytes();
            UserDto u = JsonUtil.jsonToData(UserDto.class, body);
            this.userUsecase.createUser(u.toModel());
            return JsonUtil.dataToJson(new CustomResponse(
                    HttpStatus.CREATED_201, true, u, "add me"));
        };
    }

    public Route login() {
        return (Request req, Response res) -> {
            byte[] body = req.bodyAsBytes();
            UserDto u = JsonUtil.jsonToData(UserDto.class, body);
            if (u.getEmail().isEmpty() || u.getPassword().isEmpty()) {
                Spark.halt(HttpStatus.UNAUTHORIZED_401, JsonUtil.dataToJson(new CustomResponse(
                        HttpStatus.UNAUTHORIZED_401, false, new EmptyJson(), "invalid username or password")));
            }
            
            Jwt jwt = this.userUsecase.login(u.toModel());
            if(jwt == null){
                Spark.halt(HttpStatus.UNAUTHORIZED_401, JsonUtil.dataToJson(new CustomResponse(
                        HttpStatus.UNAUTHORIZED_401, false, new EmptyJson(), "invalid username or password")));
            }

            return JsonUtil.dataToJson(new CustomResponse(
                    HttpStatus.OK_200, true, u.toModel().toJwtDto(jwt), "login success"));
        };
    }

    @Override
    public void addRoutes() {
        Spark.get("", index());
        Spark.post("", addUser());
        Spark.post("/login", login());
        Spark.get("/me", me());
    }

}
