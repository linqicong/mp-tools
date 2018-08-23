package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.user.TagsGetByUserResponse;
import com.boal.wechat.response.user.TagsGetResponse;
import com.google.gson.annotations.SerializedName;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TagsGetByUserRequest extends BaseRequest<TagsGetByUserResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/tags/getidlist";

    private PostMethod postMethod = PostMethod.POST;

    private ParamContent paramContent = new ParamContent();
    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public Object getParamContent() {
        return paramContent;
    }

    @Override
    public Class<TagsGetByUserResponse> getResponseClass() {
        return TagsGetByUserResponse.class;
    }

    @Override
    public PostMethod getPostMethod() {
        return postMethod;
    }

    @Override
    public String getUrl() {
        return url;
    }


    public static class ParamContent {
        @SerializedName("openid")
        private String openId;


        @Override
        public String toString() {
            return "ParamContent{" +
                    "openId='" + openId + '\'' +
                    '}';
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }
    }
    public void setOpenId(String openId) {
        this.paramContent.openId = openId;
    }


    public String getOpenId() {
        return this.paramContent.openId;
    }

}
