package com.boal.mptools;

import com.boal.wechat.api.WechatMpApi;
import com.boal.wechat.request.user.UserInfoBatchGetRequest;
import com.boal.wechat.response.BaseResponse;
import com.boal.wechat.response.user.UserInfoBatchGetResponse;
import com.boal.wechat.response.user.UserInfoResponse;
import com.boal.wechat.util.GsonFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApiTest  {
    @Autowired
    private WechatMpApi wechatMpApi;

    @Test
    public void getUserInfo(){
        UserInfoResponse response = wechatMpApi.userApi().getUserInfo("oQTlxtx-wFwdANHiS1j810MQAjLg",null);
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    @Test
    public void batchGetUsers(){
        List<String> openIds = new ArrayList<>();
        openIds.add("oQTlxtx-wFwdANHiS1j810MQAjLg");
        openIds.add("oQTlxt7ffbPkf2Wzg9w30aSq0DZE");
        UserInfoBatchGetResponse response = wechatMpApi.userApi().batchGetUsers(openIds,null);
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    @Test
    public void getUserList(){
        BaseResponse response = wechatMpApi.userApi().getUserList(null);
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    @Test
    public void batchBlackList(){
        List<String> openIds = new ArrayList<>();
        openIds.add("oQTlxtx-wFwdANHiS1j810MQAjLg");
        openIds.add("oQTlxt7ffbPkf2Wzg9w30aSq0DZE");
        BaseResponse response = wechatMpApi.userApi().batchBlackList(openIds);
        System.out.println(GsonFactory.getGson().toJson(response));
    }
    @Test
    public void getBlackList(){
        BaseResponse response = wechatMpApi.userApi().getBlackList(null);
        System.out.println(GsonFactory.getGson().toJson(response));
    }
    @Test
    public void batchUnBlackList(){
        List<String> openIds = new ArrayList<>();
        openIds.add("oQTlxtx-wFwdANHiS1j810MQAjLg");
        openIds.add("oQTlxt7ffbPkf2Wzg9w30aSq0DZE");
        BaseResponse response = wechatMpApi.userApi().batchUnBlackList(openIds);
        System.out.println(GsonFactory.getGson().toJson(response));
    }
}
