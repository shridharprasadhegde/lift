package com.liftUp.Utils;


import com.liftUp.model.Account;
import com.liftUp.model.Users;

/**
 * Created by spjayara on 02/10/19.
 */
public class ValidationUtils {


    public static boolean isNullOrEmpty(Users users){

        boolean isNullOrEmpty=false;

        if(users==null || users.getUsers()==null || users.getUsers().isEmpty()){
            isNullOrEmpty=true;
        }
        return isNullOrEmpty;

    }

    public static void validateTwitterAccountNames(Account accounts) throws IllegalArgumentException{

        if(accounts==null || accounts.getTwitterAccountFirst()==null || accounts.getTwitterAccountFirst().isEmpty()
                || accounts.getTwitterAccountSecond()==null || accounts.getTwitterAccountSecond().isEmpty()){

            throw  new IllegalArgumentException("Entered Inputs are not valid");

        }

    }
}
