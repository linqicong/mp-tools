package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.user.TagsGetResponse;
import com.boal.wechat.response.user.UserGetByTagResponse;
import com.boal.wechat.response.user.UserInfoResponse;
import com.boal.wechat.util.GsonFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Function;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/17<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class UserGetByTagRequest extends BaseRequest<UserGetByTagResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/user/tag/get";

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
    public Class<UserGetByTagResponse> getResponseClass() {
        return UserGetByTagResponse.class;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public PostMethod getPostMethod() {
        return postMethod;
    }

    @Override
    public Function<String, UserGetByTagResponse> getConverterFunction(){
        Gson gson = GsonFactory.getGson();
        JsonParser jsonParser = GsonFactory.getJsonParser();
        return new Function<String, UserGetByTagResponse>() {
            @Override
            public UserGetByTagResponse apply(String s) {

                UserGetByTagResponse response = gson.fromJson(s,getResponseClass());
                if (response.isSuccess() && response.getCount()>0){
                    JsonObject json = jsonParser.parse(s).getAsJsonObject();
                    response.setOpenid(gson.fromJson(json.getAsJsonObject("data").get("openid"), List.class));
                }
                return response;
            }
        };
    }

    public static class ParamContent {
        @SerializedName("tagid")
        private int tagid;

        @SerializedName("next_openid")
        private String nextOpenid;

        @Override
        public String toString() {
            return "ParamContent{" +
                    "tagid='" + tagid + '\'' +
                    ", nextOpenid='" + nextOpenid + '\'' +
                    '}';
        }

        public int getTagid() {
            return tagid;
        }

        public void setTagid(int tagid) {
            this.tagid = tagid;
        }

        public String getNextOpenid() {
            return nextOpenid;
        }

        public void setNextOpenid(String nextOpenid) {
            this.nextOpenid = nextOpenid;
        }
    }
    public void setTagid(int tagid) {
        this.paramContent.tagid = tagid;
    }

    public int getTagid() {
        return this.paramContent.tagid;
    }

    public void setNextOpenid(String nextOpenid) {
        this.paramContent.nextOpenid = nextOpenid;
    }

    public String getNextOpenid() {
        return this.paramContent.nextOpenid;
    }
}
