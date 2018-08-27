package com.boal.wechat.request.menu;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.model.Menu;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.user.UserListResponse;
import com.boal.wechat.util.GsonFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
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
public class MenuCreateRequest extends BaseRequest<NoParamResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/menu/create";

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
    public Class<NoParamResponse> getResponseClass() {
        return NoParamResponse.class;
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
        private List<Menu> button = new ArrayList<>();

        public List<Menu> getButton() {
            return button;
        }

        public void setButton(List<Menu> button) {
            this.button = button;
        }

        @Override
        public String toString() {
            return "ParamContent{" +
                    "button=" + button +
                    '}';
        }
    }
    public List<Menu> getButton() {
        return this.paramContent.button;
    }

    public void setButton(List<Menu> button) {
        this.paramContent.button = button;
    }
}
