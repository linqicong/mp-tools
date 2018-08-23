package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.model.Tag;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.user.TagCreateResponse;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TagCreateRequest extends BaseRequest<TagCreateResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/tags/create";

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
    public Class<TagCreateResponse> getResponseClass() {
        return TagCreateResponse.class;
    }

    @Override
    public PostMethod getPostMethod() {
        return postMethod;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setTag(Tag tag) {
        this.paramContent.tag = tag;
    }

    public static class ParamContent {

        private Tag tag;

        public Tag getTag() {
            return tag;
        }

        public void setTag(Tag tag) {
            this.tag = tag;
        }

        @Override
        public String toString() {
            return "ParamContent{" +
                    "tag=" + tag +
                    '}';
        }
    }
}
