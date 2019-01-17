package com.bhinneka.cahayu;

import com.bhinneka.cahayu.jwt.CustomClaim;
import com.bhinneka.cahayu.jwt.IJwtService;
import com.bhinneka.cahayu.jwt.JwtServiceImpl;
import com.bhinneka.cahayu.jwt.KeyReader;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.impl.crypto.RsaProvider;
import java.security.Key;
import java.security.KeyPair;
import java.util.Calendar;
import java.util.Date;

/**
 * created by Wuriyanto 16 01 2019
 *
 */
public class App {

    String privateKeyPath = getClass().getClassLoader().getResource("rsapriv.der").getPath();
    String publicKeyPath = getClass().getClassLoader().getResource("rsapub.der").getPath();

    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.load();
        int port = Integer.parseInt(dotenv.get("PORT"));

        Server server = new Server(port);
        server.start();

//        App app = new App();
//        
//        KeyPair kp = RsaProvider.generateKeyPair();
//        Key privateKey = KeyReader.getPrivateKey(app.privateKeyPath);
//        Key publicKey = KeyReader.getPublicKey(app.publicKeyPath);
//        
//        
//        IJwtService jwtService = new JwtServiceImpl(privateKey, publicKey);
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.HOUR_OF_DAY, 17);
//        cal.set(Calendar.MINUTE, 30);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        cal.set(Calendar.MONTH, Calendar.AUGUST);
//        cal.set(Calendar.YEAR, 2019);
//        cal.set(Calendar.DATE, 13);
//
//        Date d = cal.getTime();
//        String jwtToken = jwtService.generate(new CustomClaim("001", "bhinneka.com", "my-service", cal.getTime()));
//
//        String expectedSub = "001";
//
//        try {
//            CustomClaim cc = jwtService.validate(jwtToken);
//            System.out.println(cc);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}
