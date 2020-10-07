package com.springSecuritywithJwt.spring.Security.Jwt.AllPackagess.Config;

public class Token {
    public String getJwt() {
        return Jwt;
    }

    public void setJwt(String jwt) {
        Jwt = jwt;
    }
    public Token(){}
    public Token(String jwt) {
        Jwt = jwt;
    }

    private  String Jwt;
}
