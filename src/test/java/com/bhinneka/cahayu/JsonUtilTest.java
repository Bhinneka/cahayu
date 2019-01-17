/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu;

import com.bhinneka.cahayu.modules.user.model.User;
import com.bhinneka.cahayu.shared.JsonUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
        String jsonString = "{ \"id\": \"USR002\",  \"firstName\": \"James\", \"lastName\": \"Gosling\",  \"email\": \"james@bhinneka.com\"}";
        try {
            User u = JsonUtil.jsonToData(User.class, jsonString.getBytes());
            String expectedFirstName = "James";

            assertEquals(expectedFirstName, u.getFirstName());
        } catch (IOException ex) {
            Logger.getLogger(JsonUtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testObjectToJson() {
        User u = new User("USR1", "Wuriyanto", "Musobar", "wuriyanto@bhinneka.com", "12345");

        String jsonResult = JsonUtil.dataToJson(u);

        boolean expectedJsonResult = jsonResult.contains("Wuriyanto");

        assertTrue(expectedJsonResult);
    }

}
