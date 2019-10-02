package com.liftUp.model;

/**
 * Created by spjayara on 01/10/19.
 */
public class User {

    private String id;
    private String name;
    private String screen_name;
    private String description;
    private String followers_count;
    private String friends_count;


    public User(String id,String name){
        this.id=id;
        this.name=name;
    }

    public User(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(String followers_count) {
        this.followers_count = followers_count;
    }

    public String getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(String friends_count) {
        this.friends_count = friends_count;
    }

    public String toString(){
        return "{"+"id:"+this.name+",name:"+this.name+",screen_name:"+this.screen_name+"}";
    }

    @Override
    public boolean equals(Object userObject){

        if(((User) userObject).getId().equals(this.getId())){
            return true;
        }else return false;

    }






}
