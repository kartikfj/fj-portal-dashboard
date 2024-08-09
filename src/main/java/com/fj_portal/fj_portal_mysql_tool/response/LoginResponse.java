package com.fj_portal.fj_portal_mysql_tool.response;

public class LoginResponse {
    private String token;
    private long expiresIn;

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getToken() {
        return token;
    }

}
