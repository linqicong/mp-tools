package com.boal.wechat.api.impl;

import com.boal.wechat.api.UserApi;
import com.boal.wechat.config.WechatMpConfigs;
import com.boal.wechat.process.RequestProcess;
import com.boal.wechat.request.user.UserInfoRequest;
import com.boal.wechat.response.user.UserInfoResponse;
import com.boal.wechat.util.StringUtils;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class UserApiImpl extends BaseApiImpl implements UserApi {

    private RequestProcess requestProcess;



    public static UserApi getInstance(WechatMpConfigs wechatMpConfigs){
        UserApiImpl userApi = new UserApiImpl();
        userApi.setRequestProcess(new RequestProcess(wechatMpConfigs));
        return userApi;
    }

    private void setRequestProcess(RequestProcess requestProcess){
        this.requestProcess = requestProcess;
    }

    @Override
    public UserInfoResponse getUserInfo(String openid, String lang) {
        UserInfoRequest request = new UserInfoRequest();
        request.setOpenId(openid);
        if (StringUtils.isEmpty(lang)){
            lang = "zh-cn";
        }
        request.setLang(lang);
        return requestProcess.doProcess(request);
    }
}
