/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.jwt;

import java.util.Date;

/**
 *
 * @author wurianto
 */
public class CustomClaim {

    private String subject;
    private String issuer;
    private String audience;
    private Date expiration;

    public CustomClaim() {

    }

    public CustomClaim(String subject, String issuer, String audience, Date expiration) {
        this.subject = subject;
        this.issuer = issuer;
        this.audience = audience;
        this.expiration = expiration;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

}
