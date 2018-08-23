package com.boal.wechat.api;

import com.boal.wechat.response.user.UserInfoResponse;

public interface UserApi {

    public UserInfoResponse getUserInfo(String openid,String lang);
}
