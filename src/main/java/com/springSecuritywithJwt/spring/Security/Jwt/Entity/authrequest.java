package com.springSecuritywithJwt.spring.Security.Jwt.Entity;

public class authrequest {
    private String username;
    private String password;

    public authrequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
