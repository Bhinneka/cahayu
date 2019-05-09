/*
 * Copyright 2019 wuriyanto.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wuriyanto.cahayu.filters;

import com.wuriyanto.cahayu.CustomResponse;
import com.wuriyanto.cahayu.shared.EmptyJson;
import com.wuriyanto.cahayu.shared.JsonUtil;
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
            Spark.halt(HttpStatus.UNAUTHORIZED_401, JsonUtil.dataToJson(new CustomResponse(HttpStatus.UNAUTHORIZED_401, false, new EmptyJson(), "authorization is required")));
        }
        System.out.println("AUTH : "+authorization);
    }
    
}
