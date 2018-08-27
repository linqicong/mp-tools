package com.boal.wechat.request.menu;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.menu.MenuGetResponse;
import com.boal.wechat.response.user.TagsGetResponse;
import com.boal.wechat.util.GsonFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;
import java.util.function.Function;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MenuGetRequest extends BaseRequest<MenuGetResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/menu/get";

    private PostMethod postMethod = PostMethod.GET;


    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public Object getParamContent() {
        return null;
    }

    @Override
    public Class<MenuGetResponse> getResponseClass() {
        return MenuGetResponse.class;
    }

    @Override
    public PostMethod getPostMethod() {
        return postMethod;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Function<String, MenuGetResponse> getConverterFunction(){
        Gson gson = GsonFactory.getGson();
        JsonParser jsonParser = GsonFactory.getJsonParser();
        return new Function<String, MenuGetResponse>() {
            @Override
            public MenuGetResponse apply(String s) {

                MenuGetResponse response = gson.fromJson(s,getResponseClass());
                if (response.isSuccess()){
                    JsonObject json = jsonParser.parse(s).getAsJsonObject();
                    if (json.getAsJsonObject("menu")!=null && json.getAsJsonObject("menu").getAsJsonArray("button")!=null){
                        response.setButton(gson.fromJson(json.getAsJsonObject("menu").get("button"), List.class));
                    }
                }
                return response;
            }
        };
    }


}
