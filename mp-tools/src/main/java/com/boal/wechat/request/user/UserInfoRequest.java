package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.user.UserInfoResponse;
import com.google.gson.annotations.SerializedName;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/17<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class UserInfoRequest extends BaseRequest<UserInfoResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/user/info";

    private PostMethod postMethod = PostMethod.GET;



    private ParamContent paramContent = new ParamContent();
    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public ParamContent getParamContent() {
        return paramContent;
    }

    @Override
    public Class<UserInfoResponse> getResponseClass() {
        return UserInfoResponse.class;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public PostMethod getPostMethod() {
        return postMethod;
    }

    public static class ParamContent {
        @SerializedName("openid")
        private String openId;

        @SerializedName("lang")
        private String lang;

        @Override
        public String toString() {
            return "ParamContent{" +
                    "openId='" + openId + '\'' +
                    ", lang='" + lang + '\'' +
                    '}';
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
    }
    public void setOpenId(String openId) {
        this.paramContent.openId = openId;
    }

    public String getLang() {
        return this.paramContent.lang;
    }

    public void setLang(String lang) {
        this.paramContent.lang = lang;
    }

    public String getOpenId() {
        return this.paramContent.openId;
    }
}
