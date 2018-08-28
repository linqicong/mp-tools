package com.boal.wechat.api;

import com.boal.wechat.api.impl.MenuApiImpl;
import com.boal.wechat.api.impl.MessageApiImpl;
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

    private MenuApi menuApi;

    private MessageApi messageApi;

    private WechatMpConfigs wechatMpConfigs;

    public WechatMpApi (WechatMpConfigs wechatMpConfigs){
        this.wechatMpConfigs = wechatMpConfigs;
        userApi = UserApiImpl.getInstance(this.wechatMpConfigs);
        menuApi = MenuApiImpl.getInstance(this.wechatMpConfigs);
        messageApi = MessageApiImpl.getInstance(this.wechatMpConfigs);
    }

    public UserApi userApi(){
        return userApi;
    }

    public MenuApi menuApi(){
        return menuApi;
    }

    public MessageApi messageApi(){
        return messageApi;
    }
}
