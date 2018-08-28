package com.boal.wechat.request.message;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.model.TemplateMessage;
import com.boal.wechat.model.message.BasicMsg;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.NoParamResponse;
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
public class CustomMsgSendRequest extends BaseRequest<NoParamResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

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
    @Override
    public String toJsonString() {

        return GsonFactory.getGson().toJsonTree(this.getParamContent()).getAsJsonObject().getAsJsonObject("basicMsg").toString();
    }

    public void setBasicMsg(BasicMsg basicMsg) {
        this.paramContent.basicMsg = basicMsg;
    }

    public static class ParamContent {

        private BasicMsg basicMsg;

        public BasicMsg getBasicMsg() {
            return basicMsg;
        }

        public void setBasicMsg(BasicMsg basicMsg) {
            this.basicMsg = basicMsg;
        }

        @Override
        public String toString() {
            return "ParamContent{" +
                    "basicMsg=" + basicMsg +
                    '}';
        }
    }
}
