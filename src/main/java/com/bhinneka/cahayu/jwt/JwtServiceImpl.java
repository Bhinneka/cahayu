/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.security.Key;
import java.util.Date;

/**
 *
 * @author wurianto
 */
public class JwtServiceImpl implements IJwtService {

    private final Key privateKey;
    private final Key publicKey;

    public JwtServiceImpl(Key privateKey, Key publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    @Override
    public String generate(CustomClaim claim) {
        String jwt = Jwts.builder().setSubject(claim.getSubject())
                .setIssuer(claim.getIssuer())
                .setAudience(claim.getAudience())
                .setExpiration(claim.getExpiration())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.RS256, this.privateKey)
                .compact();
        return jwt;
    }

    @Override
    public CustomClaim validate(String jwt) {
        CustomClaim cc;
        try {
            Claims c = Jwts.parser().setSigningKey(this.publicKey).parseClaimsJws(jwt).getBody();
            cc = new CustomClaim(c.getSubject(), c.getIssuer(), c.getAudience(), c.getExpiration());
            cc.setIssuedAt(c.getIssuedAt());
            cc.setNotBefore(c.getNotBefore());
            cc.setId(cc.getId());

        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            throw e;
        }

        return cc;
    }

}
