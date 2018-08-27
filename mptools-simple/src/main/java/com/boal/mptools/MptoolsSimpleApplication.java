package com.boal.mptools;

import com.boal.wechat.api.WechatMpApi;
import com.boal.wechat.config.WechatMpConfigs;
import com.boal.wechat.response.user.UserInfoResponse;
import com.boal.wechat.util.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/23<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
@SpringBootApplication
@RestController
public class MptoolsSimpleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MptoolsSimpleApplication.class, args);
    }

    @Autowired
    private WechatMpApi wechatMpApi;

    @RequestMapping("getUserInfo")
    public String getUserInfo(String openId){
       UserInfoResponse response = wechatMpApi.userApi().getUserInfo(openId,null);
       return GsonFactory.getGson().toJson(response);
    }

    @RequestMapping("getUserInfo2")
    public String getUserInfo2(String openId){
        WechatMpConfigs wechatMpConfigs = WechatMpConfigs.init("appid","secret","127.0.0.1",6379,3000,null,0);
        WechatMpApi wechatMpApi = new WechatMpApi(wechatMpConfigs);
        wechatMpApi.userApi().getUserInfo(openId,null);
        return GsonFactory.getGson().toJson(wechatMpApi.userApi().getUserInfo(openId,null));
    }
    @RequestMapping("getUserInfo3")
    public String getUserInfo3(String openId){
        WechatMpConfigs wechatMpConfigs = WechatMpConfigs.init();
        WechatMpApi wechatMpApi = new WechatMpApi(wechatMpConfigs);
        wechatMpApi.userApi().getUserInfo(openId,null);
        return GsonFactory.getGson().toJson(wechatMpApi.userApi().getUserInfo(openId,null));
    }
}
