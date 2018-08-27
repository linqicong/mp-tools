package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.user.UserInfoBatchGetResponse;
import com.boal.wechat.response.user.UserInfoResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/17<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class UserInfoBatchGetRequest extends BaseRequest<UserInfoBatchGetResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/user/info/batchget";

    private PostMethod postMethod = PostMethod.POST;



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
    public Class<UserInfoBatchGetResponse> getResponseClass() {
        return UserInfoBatchGetResponse.class;
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
        @SerializedName("user_list")
        private List<Map<String,Object>> userList = new ArrayList<>();

        @Override
        public String toString() {
            return "ParamContent{" +
                    "userList=" + userList +
                    '}';
        }

        public List<Map<String, Object>> getUserList() {
            return userList;
        }

        public void setUserList(List<Map<String, Object>> userList) {
            this.userList = userList;
        }
    }
    public List<Map<String, Object>> getUserList() {
        return this.paramContent.userList;
    }

    public void setUserList(List<Map<String, Object>> userList) {
        this.paramContent.userList = userList;
    }
}
