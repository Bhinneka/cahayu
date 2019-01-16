/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 *
 * @author wurianto
 */
public class JwtServiceImpl implements IJwtService{
    
    private final byte[] key;
    
    public JwtServiceImpl(byte[] key) {
        this.key = key;
    }

    @Override
    public String generate(CustomClaim claim) {
        String jwt = Jwts.builder().setSubject(claim.getSubject())
                .setIssuer(claim.getIssuer())
                .setAudience(claim.getAudience())
                .setExpiration(claim.getExpiration())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.RS256, this.key)
                .compact();
        return jwt;
    }
    
}
