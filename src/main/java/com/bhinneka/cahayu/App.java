package com.bhinneka.cahayu;

import com.bhinneka.cahayu.jwt.CustomClaim;
import com.bhinneka.cahayu.jwt.IJwtService;
import com.bhinneka.cahayu.jwt.JwtServiceImpl;
import com.bhinneka.cahayu.jwt.KeyReader;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.impl.crypto.RsaProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.KeyPair;
import java.util.Calendar;
import java.util.Date;

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

        App app = new App();

//        InputStream privateKeyInput = App.class.getResourceAsStream("rsapriv.der");
//        InputStream publicKeyInput = App.class.getResourceAsStream("rsapub.der");
//
//        String privateKeyPath = App.class.getResourceAsStream("rsapriv.der");
//        String publicKeyPath = App.class.getResourceAsStream("rsapub.der");
//
//        Key privateKey = KeyReader.getPrivateKey(privateKeyPath);
//        Key publicKey = KeyReader.getPublicKey(publicKeyPath);

        // ya ya
        KeyPair kp = RsaProvider.generateKeyPair();
        // generate private and public key
        Key privateKey = kp.getPrivate();
        Key publicKey = kp.getPublic();

        Server server = new Server(port, privateKey, publicKey);
        server.start();
//        
//        
//        IJwtService jwtService = new JwtServiceImpl(privateKey, publicKey);
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.MONTH, Calendar.AUGUST);
//        cal.set(Calendar.YEAR, 2019);
//        cal.set(Calendar.DATE, 13);
//        cal.set(Calendar.HOUR_OF_DAY, 17);
//        cal.set(Calendar.MINUTE, 30);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
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

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
