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
package com.bhinneka.cahayu.shared.cache;

import redis.clients.jedis.Jedis;

/**
 *
 * @author wurianto
 */
public class CacheRedis implements ICache {

    private final Jedis jedis;

    public CacheRedis(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public String set(String key, String value) {
        return jedis.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }
// USAGE
//    public static void main(String[] args) {
//        // pass devpass
//        Redis r = new Redis("localhost", "devpass", 6379, 0, 0, false);
//        try (Jedis jedis = r.getJedisPool().getResource()) {
//            ICache cache = new CacheRedis(jedis);
////            Person wury = new Person("1", "Wuriyanto");
////            String json = JsonUtil.dataToJson(wury);
////            cache.set("1", json);
//
//            Person wury = JsonUtil.jsonToData(Person.class, cache.get("1").getBytes());
//            System.out.println(wury.getId());
//            System.out.println(wury.getName());
//        } catch (IOException ex) {
//           System.out.println(ex);
//        }
//    }
}
