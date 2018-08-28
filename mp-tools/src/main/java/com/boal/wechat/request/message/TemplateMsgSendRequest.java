package com.boal.wechat.request.message;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.model.Tag;
import com.boal.wechat.model.TemplateMessage;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.message.TemplateMsgSendResponse;
import com.boal.wechat.util.GsonFactory;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TemplateMsgSendRequest extends BaseRequest<TemplateMsgSendResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/message/template/send";

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
    public Class<TemplateMsgSendResponse> getResponseClass() {
        return TemplateMsgSendResponse.class;
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
    public String toJsonString() {

        return GsonFactory.getGson().toJsonTree(this.getParamContent()).getAsJsonObject().getAsJsonObject("templateMessage").toString();
    }

    public void setTemplateMessage(TemplateMessage templateMessage) {
        this.paramContent.templateMessage = templateMessage;
    }

    public static class ParamContent {

        private TemplateMessage templateMessage;

        public TemplateMessage getTemplateMessage() {
            return templateMessage;
        }

        public void setTemplateMessage(TemplateMessage templateMessage) {
            this.templateMessage = templateMessage;
        }

        @Override
        public String toString() {
            return "ParamContent{" +
                    "templateMessage=" + templateMessage +
                    '}';
        }
    }
}
