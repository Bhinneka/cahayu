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
        CustomClaim cc = null;
        String[] jwtSplit = jwt.split(" ");
        if(jwtSplit.length < 2 || jwtSplit.length > 2) {
            return null;
        }

        String token = jwtSplit[1];

        try {
            Claims c = Jwts.parser().setSigningKey(this.publicKey).parseClaimsJws(token).getBody();
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
