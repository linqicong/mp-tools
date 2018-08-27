package com.boal.wechat.request.menu;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.menu.MenuGetResponse;
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
public class MenuDelRequest extends BaseRequest<NoParamResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/menu/delete";

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
    public Class<NoParamResponse> getResponseClass() {
        return NoParamResponse.class;
    }

    @Override
    public PostMethod getPostMethod() {
        return postMethod;
    }

    @Override
    public String getUrl() {
        return url;
    }




}
