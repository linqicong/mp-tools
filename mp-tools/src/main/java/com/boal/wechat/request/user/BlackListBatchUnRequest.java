package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.NoParamResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/17<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class BlackListBatchUnRequest extends BaseRequest<NoParamResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist";

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

        @SerializedName("openid_list")
        private List<String> openidList = new ArrayList<>();

        public List<String> getOpenidList() {
            return openidList;
        }

        public void setOpenidList(List<String> openidList) {
            this.openidList = openidList;
        }


        @Override
        public String toString() {
            return "ParamContent{" +
                    ", openidList=" + openidList +
                    '}';
        }
    }

    public List<String> getOpenidList() {
        return this.paramContent.openidList;
    }

    public void setOpenidList(List<String> openidList) {
        this.paramContent.openidList = openidList;
    }

}
