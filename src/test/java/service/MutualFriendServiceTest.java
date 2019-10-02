package service;


import com.liftUp.service.impl.MutualFriendServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;


import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by spjayara on 02/10/19.
 */
@RunWith(JUnit4ClassRunner.class)
public class MutualFriendServiceTest {


    private static MutualFriendServiceImpl mutualFriendService;

    @BeforeClass
    public static void initialize(){

        mutualFriendService=new MutualFriendServiceImpl();
        mutualFriendService.setRestTemplate(new RestTemplate());

    }


    @Test
    public void getEncodedCredentialsTest() throws Exception{

        String result="Basic cXQ2a05FV2NSUGVvdWlZOXMwdk1IdjE5ODpWb3ZMcjVJa2Z0ZTU5ZWh1VjVmT2w2dTc2NVlqNzlMcEFqU3dFekg0SjdjMmFSTmtmSQ==";
        String encodedCredentials=mutualFriendService.getEncodedCredentials();
        assertEquals(result,encodedCredentials);
    }

    @Test
    public void getTokenTest()throws Exception{
        String encodedCredentials=mutualFriendService.getEncodedCredentials();
        String token=mutualFriendService.getToken();
        assertNotNull(token);
    }

    //Commented these test cases to avoid HttpClientErrorException$TooManyRequests: 429 Too Many Requests
    //Requests / 15-min window (user auth)	15
    //Requests / 15-min window (app auth)	15


    /*
    @Test
    public void getFriendsByTwitterAccountSizeTest()throws Exception{
        String accountName="hosahalli2";
        Users users=mutualFriendService.getFriendsByTwitterAccount(accountName);
        System.out.println(users.getUsers().size());
        //assertEquals(2,users.getUsers().size());

    }



    @Test
    public void getFriendsByTwitterAccountValueTest()throws Exception{
        String accountName="hosahalli2";
        Users users=mutualFriendService.getFriendsByTwitterAccount(accountName);
        //assertEquals("1178906040202481664",users.getUsers().get(0).getId());
        System.out.println(users.getUsers().get(1).getId());
        System.out.println(users.getUsers().get(0).getId());
        //assertEquals("1178906040202481664",users.getUsers().get(1).getId());
    }


    @Test
    public void getMutualFriendsByTwitterAccountSizeTest()throws Exception{
        String accountNameOne="hosahalli2";
        String accountNameTwo="HosahalliPrasad";
        Set<User> users=mutualFriendService.fetchMutualFriends(accountNameOne,accountNameTwo);
        System.out.println(users.size());
        //assertEquals(1,users.size());
    }

    */




}
