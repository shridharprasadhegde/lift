package com.liftUp.model;

/**
 * Created by spjayara on 02/10/19.
 */
public class Account {

    private String twitterAccountFirst;
    private String twitterAccountSecond;

    public Account(){

    }

    public String getTwitterAccountFirst() {
        return twitterAccountFirst;
    }

    public void setTwitterAccountFirst(String twitterAccountFirst) {
        this.twitterAccountFirst = twitterAccountFirst;
    }

    public String getTwitterAccountSecond() {
        return twitterAccountSecond;
    }

    public void setTwitterAccountSecond(String twitterAccountSecond) {
        this.twitterAccountSecond = twitterAccountSecond;
    }

    public String toString(){
        return "{ account:"+this.twitterAccountFirst+","+this.twitterAccountSecond+"}";
    }


}
