package com.liftUp.service.impl;

import com.liftUp.Utils.ValidationUtils;
import com.liftUp.model.Token;
import com.liftUp.model.User;
import com.liftUp.model.Users;
import com.liftUp.service.MutualFriendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.util.*;

/**
 * Created by spjayara on 02/10/19.
 */
@Service
public class MutualFriendServiceImpl implements MutualFriendService {


    @Autowired
    private RestTemplate restTemplate;


    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }




    private static final Logger logger= LoggerFactory.getLogger(MutualFriendServiceImpl.class);


    private static final String consumerKey="qt6kNEWcRPeouiY9s0vMHv198";
    private static final String consumerSecretKey="VovLr5Ikfte59ehuV5fOl6u765Yj79LpAjSwEzH4J7c2aRNkfI";
    private static final String credentials=consumerKey+":"+consumerSecretKey;
    private static final String oauthUrl="https://api.twitter.com/oauth2/token";
    private static String url="https://api.twitter.com/1.1/friends/list.json?screen_name={accountName}&skip_status=true&include_user_entities=false&count=200";

    public String getEncodedCredentials() throws UnsupportedEncodingException{
        String encodedCredentials=null;
        try {
            encodedCredentials = "Basic " + Base64.getEncoder().encodeToString(
                    credentials.getBytes("utf-8"));
        }catch (UnsupportedEncodingException e){
            logger.error("Unsupported Encoding exeception ");
            throw e;
        }
        return encodedCredentials;
    }

    public String getToken() throws Exception{

        String token=null;
        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization",getEncodedCredentials());
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        String body="grant_type=client_credentials";
        HttpEntity<Object> httpEntity=new HttpEntity<>(body,headers);
        ResponseEntity<Token> result =restTemplate.exchange(oauthUrl, HttpMethod.POST,httpEntity, Token.class);

        if(result.getBody()!=null && result.getBody().getAccess_token()!=null){
            token=result.getBody().getAccess_token();
        }
        return token;
    }

    public Users getFriendsByTwitterAccount(String accountName)throws Exception{

        Users users=null;
        //String cursor="-1";

        String body="grant_type=client_credentials";
        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization","Bearer "+getToken());
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        HttpEntity<Object> httpEntity=new HttpEntity<>(body,headers);
        Map<String,String> urlParams=new HashMap<>();
        urlParams.put("accountName",accountName);
        //urlParams.put("cursorValue", cursor);
        UriTemplate template = new UriTemplate(url);
        URI uri = template.expand(urlParams);
        ResponseEntity<Users> userResults = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Users.class);

        if (userResults.getBody() != null && userResults.getBody().getUsers() != null) {
            users = userResults.getBody();
        }

        return users;
    }

    public Set<User> fetchMutualFriends(String accountNameOne,String accountNameTwo) throws Exception{


        Set<User> mutualFriends=new HashSet<>();

        Users friendsFromAccountOne=getFriendsByTwitterAccount(accountNameOne);
        Users friendsFromAccountTwo=getFriendsByTwitterAccount(accountNameTwo);

        if(ValidationUtils.isNullOrEmpty(friendsFromAccountOne) || ValidationUtils.isNullOrEmpty(friendsFromAccountTwo)){
            return mutualFriends;
        }

        Set<String> friendSetFromAccountOne=new HashSet<>();
        for(User u:friendsFromAccountOne.getUsers()){
            friendSetFromAccountOne.add(u.getId());
        }

        for(User u:friendsFromAccountTwo.getUsers()){
            if(friendSetFromAccountOne.contains(u.getId())){
                mutualFriends.add(u);
            }
        }

        return mutualFriends;
    }



}
