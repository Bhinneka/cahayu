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
package com.bhinneka.cahayu.database;

import java.time.Duration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * @author wurianto
 */
public class Redis {

    private final JedisPool jedisPool;

    public Redis(String host, String password, Integer port, Integer timeout, Integer database, boolean ssl) {
        final JedisPoolConfig poolConfig = buildPoolConfig();
        jedisPool = new JedisPool(poolConfig, host, port, timeout, password, database);
    }

    private JedisPoolConfig buildPoolConfig() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    //USAGE
    // SET
//    public static void main(String[] args) {
//        // pass devpass
//        Redis r = new Redis("localhost", "devpass", 6379, 0, 0, false);
//        try (Jedis jedis = r.getJedisPool().getResource()){
//            jedis.set("1", "wury");
//        }
//    }
    
        // GET
//    public static void main(String[] args) {
//        // pass devpass
//        Redis r = new Redis("localhost", "devpass", 6379, 0, 0, false);
//        try (Jedis jedis = r.getJedisPool().getResource()){
//            String value = jedis.get("1");
//            System.out.println(value);
//        }
//    }
    
    // SET expired
//    public static void main(String[] args) {
//        // pass devpass
//        Redis r = new Redis("localhost", "devpass", 6379, 0, 0, false);
//        try (Jedis jedis = r.getJedisPool().getResource()) {
//            String key = "1";
//            jedis.set(key, "wury");
//            jedis.expire(key, 6);
//        }
//    }
    
    // SUBSCRIBE
//    public static void main(String[] args) {
//        // pass devpass
//        Redis r = new Redis("localhost", "devpass", 6379, 0, 0, false);
//        try (Jedis jedis = r.getJedisPool().getResource()) {
//            jedis.subscribe(new JedisPubSub() {
//                
//                @Override
//                public void onMessage(String channel, String message) {
//                    System.out.println(message);
//                }
//                
//            }, "channel");
//        }
//    }
    
    // SUBSCRIBE expired event
    // make sure expired config is configured
    // if not set using this command
    // CONFIG SET notify-keyspace-events KEx
    // further reading https://redis.io/topics/notifications
//    public static void main(String[] args) {
//        // pass devpass
//        Redis r = new Redis("localhost", "devpass", 6379, 0, 0, false);
//        try (Jedis jedis = r.getJedisPool().getResource()) {
//
//            jedis.psubscribe(new JedisPubSub() {
//                @Override
//                public void onPSubscribe(String pattern, int subscribedChannels) {
//                    System.out.println("onPSubscribe " + pattern + " " + subscribedChannels);
//                }
//
//                @Override
//                public void onPMessage(String pattern, String channel, String message) {
//                    System.out
//                            .println("onPMessage pattern "
//                                    + pattern + " " + channel + " " + message);
//                }
//
//            }, "__keyevent@*__:expired");
//        }
//    }

}
