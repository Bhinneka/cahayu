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

import com.wuriyanto.cahayu.jwt.CustomClaim;
import com.wuriyanto.cahayu.jwt.IJwtService;
import com.wuriyanto.cahayu.jwt.JwtServiceImpl;
import io.jsonwebtoken.impl.crypto.RsaProvider;
import java.security.Key;
import java.security.KeyPair;
import java.util.Calendar;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author wurianto
 */
public class JwtServiceTest extends TestCase {

    KeyPair kp = RsaProvider.generateKeyPair();

    public JwtServiceTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(JwtServiceTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testGenerateJwt() {

        // generate private and public key
        Key privateKey = kp.getPrivate();
        Key publicKey = kp.getPublic();

        IJwtService jwtService = new JwtServiceImpl(privateKey, publicKey);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 17);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.MONTH, Calendar.AUGUST);
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.DATE, 13);

        String jwtToken = jwtService.generate(new CustomClaim("001", "bhinneka.com", "my-service", cal.getTime()));

        jwtToken = "Bearer " + jwtToken;

        String expectedSub = "001";

        CustomClaim cc = jwtService.validate(jwtToken);

        assertNotNull(cc);

        assertEquals(expectedSub, cc.getSubject());
    }

    public void testValidateJWT() {
        assertTrue(true);
    }

}
