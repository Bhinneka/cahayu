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
package com.wuriyanto.cahayu.jwt;

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
    private Date issuedAt;
    private Date notBefore;
    private String id;

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

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(Date notBefore) {
        this.notBefore = notBefore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomClaim{" + "subject=" + subject + ", issuer=" + issuer + ", audience=" + audience + ", expiration=" + expiration + ", issuedAt=" + issuedAt + ", notBefore=" + notBefore + ", id=" + id + '}';
    }
    
    

}
