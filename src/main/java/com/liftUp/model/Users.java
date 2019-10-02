package com.liftUp.model;

import java.util.List;

/**
 * Created by spjayara on 01/10/19.
 */
public class Users {

    private List<User> users;
    private String next_cursor_str;

    public String getNext_cursor_str() {
        return next_cursor_str;
    }

    public void setNext_cursor_str(String next_cursor_str) {
        this.next_cursor_str = next_cursor_str;
    }
    public Users(){

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String toString(){
        return "{users:["+this.getUsers()+"]}";
    }







}
