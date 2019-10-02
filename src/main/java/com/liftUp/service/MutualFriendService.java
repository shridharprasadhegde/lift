package com.liftUp.service;

import com.liftUp.model.User;
import com.liftUp.model.Users;

import java.io.UnsupportedEncodingException;
import java.util.Set;

/**
 * Created by spjayara on 02/10/19.
 */
public interface MutualFriendService {

    public Set<User> fetchMutualFriends(String accountNameOne,String accountNameTwo) throws Exception;
    public String getEncodedCredentials() throws UnsupportedEncodingException;
    public String getToken() throws Exception;
    public Users getFriendsByTwitterAccount(String accountName)throws Exception;



}
