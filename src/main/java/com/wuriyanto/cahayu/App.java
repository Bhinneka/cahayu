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
package com.wuriyanto.cahayu;

import com.wuriyanto.cahayu.jwt.KeyReader;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.InputStream;
import java.security.Key;

/**
 * created by Wuriyanto 16 01 2019
 *
 */
public class App {

    //String privateKeyPath = getClass().getResource("target/clasess/rsapriv.der").getPath();
    //String publicKeyPath = getClass().getResource("target/clasess/rsapub.der").getPath();
    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.load();
        int port = Integer.parseInt(dotenv.get("PORT"));
        String mongoDbConnectionString = dotenv.get("MONGO_DB_HOST");
        String mongoDbDatabaseName = dotenv.get("MONGO_DB_NAME");

        App app = new App();

        InputStream privateKeyInput, publicKeyInput;

        privateKeyInput = App.class.getResourceAsStream("/rsapriv.der");
        publicKeyInput = App.class.getResourceAsStream("/rsapub.der");

        Key privateKey = KeyReader.getPrivateKey(privateKeyInput);
        Key publicKey = KeyReader.getPublicKey(publicKeyInput);

        // ya ya
//        KeyPair kp = RsaProvider.generateKeyPair();
//        // generate private and public key
//        Key privateKey = kp.getPrivate();
//        Key publicKey = kp.getPublic();
//
        Server server = new Server(port, privateKey, publicKey);
        server.setMongoDbConnectionString(mongoDbConnectionString);
        server.setMongoDbDatabaseName(mongoDbDatabaseName);

        server.start();
    }
}
