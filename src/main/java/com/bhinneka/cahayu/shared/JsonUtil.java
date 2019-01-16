/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.shared;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 *
 * @author wurianto
 */
public class JsonUtil implements ResponseTransformer{
    
    private final Gson gson = new Gson();

    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }
    
}
