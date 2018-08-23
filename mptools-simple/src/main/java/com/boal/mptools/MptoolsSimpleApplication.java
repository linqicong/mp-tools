package com.boal.mptools;

import com.boal.wechat.api.WechatMpApi;
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
       return GsonFactory.getGson().toJson(wechatMpApi.userApi().getUserInfo(openId,null));
    }
}
