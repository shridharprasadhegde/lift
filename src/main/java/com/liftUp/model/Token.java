package com.liftUp.model;

/**
 * Created by spjayara on 01/10/19.
 */
public class Token {

    private String token_type;
    private String access_token;

    public Token(){

    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String toString(){
        return "{ token:"+this.getAccess_token()+"}";
    }



}
