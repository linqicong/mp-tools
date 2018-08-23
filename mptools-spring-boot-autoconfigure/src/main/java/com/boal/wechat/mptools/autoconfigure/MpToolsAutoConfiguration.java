package com.boal.wechat.mptools.autoconfigure;


import com.boal.wechat.api.WechatMpApi;
import com.boal.wechat.config.WechatMpConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MpToolsProperties.class)
public class MpToolsAutoConfiguration {

    @Autowired
    private MpToolsProperties mpToolsProperties;

    @Bean
    public WechatMpConfigs wechatMpConfigs(){
        return WechatMpConfigs.init(
                mpToolsProperties.getAppid(),
                mpToolsProperties.getSecret(),
                mpToolsProperties.getHost(),
                mpToolsProperties.getPort(),
                mpToolsProperties.getTimeout(),
                mpToolsProperties.getPassword(),
                mpToolsProperties.getDatabase());
    }

    @Bean
    public WechatMpApi wechatMpApi(){
        WechatMpApi wechatMpApi = new WechatMpApi(wechatMpConfigs());
        return wechatMpApi;
    }
}
