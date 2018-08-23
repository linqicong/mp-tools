package com.boal.wechat.api;

import com.boal.wechat.api.impl.UserApiImpl;
import com.boal.wechat.config.WechatMpConfigs;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/23<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class WechatMpApi {

    private UserApi userApi;

    private WechatMpConfigs wechatMpConfigs;

    public WechatMpApi (WechatMpConfigs wechatMpConfigs){
        this.wechatMpConfigs = wechatMpConfigs;
        userApi = UserApiImpl.getInstance(this.wechatMpConfigs);
    }

    public UserApi userApi(){
        return userApi;
    }
}
