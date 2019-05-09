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

import com.wuriyanto.cahayu.modules.user.model.User;
import com.wuriyanto.cahayu.shared.JsonUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.bson.types.ObjectId;

/**
 *
 * @author wurianto
 */
public class JsonUtilTest extends TestCase {

    public JsonUtilTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(JsonUtilTest.class);
    }

    public void testJsonToObject() {
        String jsonString = "{ \"id\": \"5c418087e86ddac693ffed90\",  \"firstName\": \"James\", \"lastName\": \"Gosling\",  \"email\": \"james@bhinneka.com\"}";
        try {
            User u = JsonUtil.jsonToData(User.class, jsonString.getBytes());
            String expectedFirstName = "James";

            assertEquals(expectedFirstName, u.getFirstName());
        } catch (IOException ex) {
            Logger.getLogger(JsonUtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testObjectToJson() {
        User u = new User(ObjectId.get(), "Wuriyanto", "Musobar", "wuriyanto@bhinneka.com", "12345");

        String jsonResult = JsonUtil.dataToJson(u);

        boolean expectedJsonResult = jsonResult.contains("Wuriyanto");

        assertTrue(expectedJsonResult);
    }

}
