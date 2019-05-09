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
package com.wuriyanto.cahayu.shared;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 *
 * @author wurianto
 */
public class HttpClient {

    public static final OkHttpClient CLIENT = new OkHttpClient();

    public static Call call(String url, String method, Headers headers, RequestBody body) {
        Request.Builder builder = new Request.Builder();
        builder.url(url);

        if (headers != null) {
            builder.headers(headers);
        }

        if (body != null) {
            builder.method(method, body);
        } else {
            builder.method(method, null);
        }

        return CLIENT.newCall(builder.build());

    }

    //USAGE:
    
    // GET ASYNC example
//    public static void main(String[] args) {
//        //Headers headers = new Headers.Builder().add(name, value)
//        //RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), payload);
//        call("https://jsonplaceholder.typicode.com/users", "GET", null, null).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println(e);
//            }
//
//            @Override
//            public void onResponse(Call call, Response res) throws IOException {
//                System.out.println(res.body().string());
//            }
//        });
//
//    }
    
    // POST ASYNC example, {"id":"1", "name": "wury"}
//     public static void main(String[] args) {
//        Headers headers = new Headers.Builder().add("Authorization", "12345").build();
//        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), "{\"id\":\"1\", \"name\": \"wury\"}");
//        call("http://localhost:8000/persons", "POST", headers, body).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println("error "+ e);
//            }
//
//            @Override
//            public void onResponse(Call call, Response res) throws IOException {
//                System.out.println(res.body().string());
//            }
//        });
//
//    }
    
    // POST SYNC
//    public static void main(String[] args) {
//        Headers headers = new Headers.Builder().add("Authorization", "12345").build();
//        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), "{\"id\":\"1\", \"name\": \"wury\"}");
//        
//        try {
//            Response response = call("http://localhost:8000/persons", "POST", headers, body).execute();
//            if (response.body() != null) {
//                System.out.println(response.body().string());
//            }
//            
//        } catch (IOException ex) {
//            System.out.println("error "+ex);
//        }
//
//    }

}
