package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.user.TagsGetResponse;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TagsGetRequest extends BaseRequest<TagsGetResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/tags/get";

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
    public Class<TagsGetResponse> getResponseClass() {
        return TagsGetResponse.class;
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
