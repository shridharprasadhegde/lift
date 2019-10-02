package com.liftUp.controllers;

import com.liftUp.Utils.ValidationUtils;
import com.liftUp.model.Account;
import com.liftUp.model.User;
import com.liftUp.service.MutualFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * Created by spjayara on 02/10/19.
 */
@RestController
public class MutualFriendController {

    @Autowired
    private MutualFriendService mutualFriendService;



    @GetMapping("/")
    public ModelAndView createMutualFriendsView(){

        ModelAndView view=new ModelAndView();
        view.setViewName("mutualFriendView");
        view.addObject("accounts",new Account());
        return view;
    }

    @GetMapping("/display")
    public ModelAndView displayMutualFriendsView(Account accounts) throws Exception{
        ModelAndView view=new ModelAndView();
        ValidationUtils.validateTwitterAccountNames(accounts);
        view.setViewName("displayMutualFriends");
        Set<User> userList=mutualFriendService.fetchMutualFriends(accounts.getTwitterAccountFirst(),accounts.getTwitterAccountSecond());
        view.addObject("allUsers",userList);
        return view;
    }

    @GetMapping("/error")
    public ModelAndView error(){

        ModelAndView view=new ModelAndView();
        view.setViewName("error");
        return view;
    }
}
