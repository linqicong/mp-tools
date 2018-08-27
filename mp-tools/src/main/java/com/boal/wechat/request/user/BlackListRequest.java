package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.model.User;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.user.BlackListResponse;
import com.boal.wechat.response.user.UserListResponse;
import com.boal.wechat.util.GsonFactory;
import com.google.gson.Gson;
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
public class BlackListRequest extends BaseRequest<BlackListResponse> {


    private String url = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist";

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
    public Class<BlackListResponse> getResponseClass() {
        return BlackListResponse.class;
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
    public Function<String, BlackListResponse> getConverterFunction(){
        Gson gson = GsonFactory.getGson();
        JsonParser jsonParser = GsonFactory.getJsonParser();
        return new Function<String, BlackListResponse>() {
            @Override
            public BlackListResponse apply(String s) {

                BlackListResponse response = gson.fromJson(s,getResponseClass());
                if (response.isSuccess() && response.getCount()>0){
                    JsonObject json = jsonParser.parse(s).getAsJsonObject();
                    response.setOpenid(gson.fromJson(json.getAsJsonObject("data").get("openid"), List.class));
                }
                return response;
            }
        };
    }

    public static class ParamContent {
        @SerializedName("next_openid")
        private String nextOpenid;

        public String getNextOpenid() {
            return nextOpenid;
        }

        public void setNextOpenid(String nextOpenid) {
            this.nextOpenid = nextOpenid;
        }

        @Override
        public String toString() {
            return "ParamContent{" +
                    "nextOpenid='" + nextOpenid + '\'' +
                    '}';
        }
    }

    public void setNextOpenid(String nextOpenid) {
        this.paramContent.nextOpenid = nextOpenid;
    }

    public String getNextOpenid() {
        return this.paramContent.nextOpenid;
    }
}
